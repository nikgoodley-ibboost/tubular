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
package org.trancecode.xml.catalog;

import com.google.common.collect.ImmutableList;


/**
 * @author Herve Quiroz
 * @version $Revision$
 */
public class MainCatalog extends Group implements ContainsDefaultCatalog
{
	public static boolean isMainCatalog(final Catalog catalog)
	{
		return catalog instanceof ContainsDefaultCatalog;
	}


	public static Catalog wrap(final Catalog catalog)
	{
		if (isMainCatalog(catalog))
		{
			return catalog;
		}

		return new MainCatalog(catalog);
	}


	private MainCatalog(final Catalog catalog)
	{
		super(ImmutableList.of(catalog, DefaultCatalog.INSTANCE), null);
		assert !(catalog instanceof MainCatalog);
	}
}
