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
package org.trancecode.xproc.parser;

import org.trancecode.xproc.XProcNamespaces;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

import net.sf.saxon.s9api.QName;


/**
 * Elements from the XProc XML model.
 * 
 * @author Herve Quiroz
 * @version $Revision$
 */
public interface XProcElements
{
	QName CHOOSE = XProcNamespaces.XPROC.newSaxonQName("choose");
	QName DECLARE_STEP = XProcNamespaces.XPROC.newSaxonQName("declare-step");
	QName DOCUMENT = XProcNamespaces.XPROC.newSaxonQName("document");
	QName EMPTY = XProcNamespaces.XPROC.newSaxonQName("empty");
	QName FOR_EACH = XProcNamespaces.XPROC.newSaxonQName("for-each");
	QName IMPORT = XProcNamespaces.XPROC.newSaxonQName("import");
	QName INLINE = XProcNamespaces.XPROC.newSaxonQName("inline");
	QName INPUT = XProcNamespaces.XPROC.newSaxonQName("input");
	QName ITERATION_SOURCE = XProcNamespaces.XPROC.newSaxonQName("iteration-source");
	QName LIBRARY = XProcNamespaces.XPROC.newSaxonQName("library");
	QName OPTION = XProcNamespaces.XPROC.newSaxonQName("option");
	QName OTHERWISE = XProcNamespaces.XPROC.newSaxonQName("otherwise");
	QName OUTPUT = XProcNamespaces.XPROC.newSaxonQName("output");
	QName PIPE = XProcNamespaces.XPROC.newSaxonQName("pipe");
	QName PIPELINE = XProcNamespaces.XPROC.newSaxonQName("pipeline");
	QName VARIABLE = XProcNamespaces.XPROC.newSaxonQName("variable");
	QName WHEN = XProcNamespaces.XPROC.newSaxonQName("when");
	QName WITH_OPTION = XProcNamespaces.XPROC.newSaxonQName("with-option");
	QName WITH_PARAM = XProcNamespaces.XPROC.newSaxonQName("with-param");
	QName XPATH_CONTEXT = XProcNamespaces.XPROC.newSaxonQName("xpath-context");

	Set<QName> ELEMENTS_CORE_STEPS = ImmutableSet.of(FOR_EACH, CHOOSE);
	Set<QName> ELEMENTS_DECLARE_STEP_OR_PIPELINE = ImmutableSet.of(DECLARE_STEP, PIPELINE);
	Set<QName> ELEMENTS_IN_PIPELINE = ImmutableSet.of(IMPORT, PIPELINE);
	Set<QName> ELEMENTS_IN_PIPELINE_LIBRARY = ImmutableSet.of(IMPORT, DECLARE_STEP, PIPELINE);
	Set<QName> ELEMENTS_PORT_BINDINGS = ImmutableSet.of(INLINE, DOCUMENT, EMPTY, PIPE);
	Set<QName> ELEMENTS_INPUT_PORTS = ImmutableSet.of(INPUT, ITERATION_SOURCE, XPATH_CONTEXT);
	Set<QName> ELEMENTS_OUTPUT_PORTS = ImmutableSet.of(OUTPUT);
	Set<QName> ELEMENTS_PORTS = ImmutableSet.copyOf(Iterables.concat(ELEMENTS_INPUT_PORTS, ELEMENTS_OUTPUT_PORTS));
	Set<QName> ELEMENTS_VARIABLES = ImmutableSet.of(VARIABLE, OPTION, WITH_OPTION, WITH_PARAM);
	Set<QName> ELEMENTS_STANDARD_PORTS = ImmutableSet.of(INPUT, OUTPUT);
	Set<QName> ELEMENTS_ROOT = ImmutableSet.of(PIPELINE, LIBRARY, DECLARE_STEP);
	Set<QName> ELEMENTS_WHEN_OTHERWISE = ImmutableSet.of(WHEN, OTHERWISE);

}