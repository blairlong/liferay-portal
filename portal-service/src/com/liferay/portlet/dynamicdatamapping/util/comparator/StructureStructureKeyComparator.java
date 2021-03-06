/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
 */

package com.liferay.portlet.dynamicdatamapping.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;

/**
 * @author Miguel Pastor
 */
public class StructureStructureKeyComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "DDMStructure.structureKey ASC";

	public static final String ORDER_BY_DESC = "DDMStructure.structureKey DESC";

	public static final String[] ORDER_BY_FIELDS = {"structureKey"};

	public StructureStructureKeyComparator() {
		this(false);
	}

	public StructureStructureKeyComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		DDMStructure structure1 = (DDMStructure)obj1;

		String structureKey1 = structure1.getStructureKey();

		structureKey1 = structureKey1.toLowerCase();

		DDMStructure structure2 = (DDMStructure)obj2;

		String structureKey2 = structure2.getStructureKey();

		structureKey2 = structureKey2.toLowerCase();

		int value = structureKey1.compareTo(structureKey2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}