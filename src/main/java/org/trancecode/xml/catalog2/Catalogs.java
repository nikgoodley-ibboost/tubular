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
package org.trancecode.xml.catalog2;

import org.trancecode.io.Uris;

import java.net.URI;

import com.google.common.base.Function;


/**
 * Utility methods related to {@link Catalog}.
 * 
 * @author Herve Quiroz
 * @version $Revision$
 */
public final class Catalogs
{
	private Catalogs()
	{
		// No instantiation
	}


	public static Function<CatalogQuery, URI> defaultCatalog()
	{
		return DefaultCatalog.INSTANCE;
	}


	private static class DefaultCatalog implements Function<CatalogQuery, URI>
	{
		public static DefaultCatalog INSTANCE = new DefaultCatalog();


		private DefaultCatalog()
		{
			// Singleton
		}


		@Override
		public URI apply(final CatalogQuery query)
		{
			if (query.systemId != null)
			{
				return Uris.createUri(query.systemId);
			}

			return Uris.resolve(query.href, query.base);
		}
	}
}
