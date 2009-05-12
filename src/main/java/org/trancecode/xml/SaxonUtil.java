/*
 * Copyright (C) 2008 TranceCode Software
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
 *
 * $Id$
 */
package org.trancecode.xml;

import org.trancecode.io.IOUtil;
import org.trancecode.xproc.XProcExceptions;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import net.sf.saxon.s9api.Axis;
import net.sf.saxon.s9api.DOMDestination;
import net.sf.saxon.s9api.ItemTypeFactory;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmAtomicValue;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmNodeKind;
import net.sf.saxon.s9api.XdmValue;
import net.sf.saxon.s9api.XsltTransformer;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.w3c.dom.Document;


/**
 * @author Herve Quiroz
 * @version $Revision$
 */
public class SaxonUtil implements XmlModel
{
	private static final XLogger LOG = XLoggerFactory.getXLogger(SaxonUtil.class);


	private SaxonUtil()
	{
		// To prevent instantiation
	}


	private static <T> Iterable<T> iterable(final Iterator<T> iterator)
	{
		return new Iterable<T>()
		{
			public Iterator<T> iterator()
			{
				return iterator;
			}
		};
	}


	public static Map<QName, String> getAttributes(final XdmNode node)
	{
		assert node != null;

		final Map<QName, String> attributes = new LinkedHashMap<QName, String>();
		for (final XdmItem xdmItem : iterable(node.axisIterator(Axis.ATTRIBUTE)))
		{
			if (xdmItem instanceof XdmNode)
			{
				final XdmNode childNode = (XdmNode)xdmItem;
				assert childNode.getNodeKind().equals(XdmNodeKind.ATTRIBUTE);
				attributes.put(childNode.getNodeName(), childNode.getStringValue());
			}
		}

		return attributes;
	}


	public static Iterable<XdmNode> getElements(final XdmNode node, final Collection<QName> names)
	{
		assert node != null;

		final List<XdmNode> nodes = new ArrayList<XdmNode>();
		for (final XdmItem xdmItem : iterable(node.axisIterator(Axis.CHILD)))
		{
			if (xdmItem instanceof XdmNode)
			{
				final XdmNode childNode = (XdmNode)xdmItem;
				if (childNode.getNodeKind().equals(XdmNodeKind.ELEMENT)
					&& (names.isEmpty() || names.contains(childNode.getNodeName())))
				{
					nodes.add(childNode);
				}

			}
		}

		return nodes;
	}


	public static Iterable<XdmNode> getElements(final XdmNode node, final QName... names)
	{
		return getElements(node, Arrays.asList(names));
	}


	public static XdmNode getElement(final XdmNode node, final QName... names)
	{
		return getElement(node, Arrays.asList(names));
	}


	public static XdmNode getElement(final XdmNode node, final Collection<QName> names)
	{
		return Iterables.getOnlyElement(getElements(node, names));
	}


	public static QName getAttributeAsQName(final XdmNode node, final QName attributeName)
	{
		final String value = node.getAttributeValue(attributeName);
		if (value != null)
		{
			return new QName(value, node);
		}

		return null;
	}


	public static Document asDomDocument(final XdmNode node, final Processor processor)
	{
		try
		{
			final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			final DOMResult domResult = new DOMResult();
			final XsltTransformer transformer = processor.newXsltCompiler().compile(null).load();
			transformer.setSource(node.asSource());
			transformer.setDestination(new DOMDestination(document));
			transformer.transform();

			return (Document)domResult.getNode();
		}
		catch (final Exception e)
		{
			throw new IllegalStateException(e);
		}
	}


	public static Object nodesToString(final XdmNode... nodes)
	{
		return nodesToString(Arrays.asList(nodes));
	}


	public static Object nodesToString(final Iterable<XdmNode> nodes)
	{
		return new Object()
		{
			@Override
			public String toString()
			{
				final List<QName> qnames = Lists.newArrayList();
				for (final XdmNode node : nodes)
				{
					if (node.getNodeKind() == XdmNodeKind.DOCUMENT)
					{
						qnames.add(new QName("document"));
					}
					else
					{
						qnames.add(node.getNodeName());
					}
				}

				return qnames.toString();
			}
		};
	}


	public static XdmValue evaluateXPath(
		final String select, final Processor processor, final XdmNode xpathContextNode,
		final Map<QName, String> variables, final Location location)
	{
		LOG.trace("select = {} ; variables = {}", select, variables);

		try
		{
			final XPathCompiler xpathCompiler = processor.newXPathCompiler();
			for (final Map.Entry<QName, String> variableEntry : variables.entrySet())
			{
				if (variableEntry.getValue() != null)
				{
					xpathCompiler.declareVariable(variableEntry.getKey());
				}
			}

			final XPathSelector selector = xpathCompiler.compile(select).load();
			if (xpathContextNode != null)
			{
				LOG.trace("xpathContextNode = {}", xpathContextNode);
				selector.setContextItem(xpathContextNode);
			}

			for (final Map.Entry<QName, String> variableEntry : variables.entrySet())
			{
				if (variableEntry.getValue() != null)
				{
					selector.setVariable(variableEntry.getKey(), new XdmAtomicValue(variableEntry.getValue()));
				}
			}

			return selector.evaluate();
		}
		catch (final Exception e)
		{
			throw XProcExceptions.xd0023(location, select, e.getMessage());
		}
	}


	public static XdmNode parse(final String xmlContent, final Processor processor)
	{
		final StringReader reader = new StringReader(xmlContent);
		try
		{
			return processor.newDocumentBuilder().build(new StreamSource(reader));
		}
		catch (final SaxonApiException e)
		{
			throw new IllegalStateException(e);
		}
		finally
		{
			IOUtil.closeQuietly(reader);
		}
	}


	public static XdmNode getEmptyDocument(final Processor processor)
	{
		return parse("<?xml version=\"1.0\"?><document/>", processor);
	}


	public static XdmItem getUntypedXdmItem(final String value, final Processor processor)
	{
		try
		{
			return new XdmAtomicValue(value, new ItemTypeFactory(processor)
				.getAtomicType(XmlSchemaModel.UNTYPED_ATOMIC));
		}
		catch (final SaxonApiException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
