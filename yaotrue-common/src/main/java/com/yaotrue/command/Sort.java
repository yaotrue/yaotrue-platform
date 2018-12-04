/**
 * Copyright (c) 2012 YaoTrue All Rights Reserved.
 *
 * This software is the confidential and proprietary information of YaoTrue.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with YaoTrue.
 *
 * YaoTrue MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. YaoTrue SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.yaotrue.command;

import java.io.Serializable;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年11月1日 下午2:46:52
 */
public class Sort implements Serializable {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = -7695379879697379731L;

	public static final String ASC = "asc";
	public static final String DESC = "desc";

	/**排序字段*/
	private String field;
	/**排序方式*/
	private String type = ASC;

	public Sort() {
		this.field = "";
		this.type = ASC;
	}

	public Sort(String sortStr) {
		String[] strs = sortStr.trim().split(" ");
		this.field = strs[0];
		if (strs.length > 1) {
			if (ASC.equalsIgnoreCase(strs[1]))
				this.type = ASC;
			else if (DESC.equalsIgnoreCase(strs[1]))
				this.type = DESC;
			else
				throw new IllegalArgumentException("Wrong sort type definition, only asc or desc are supported.");
		}
	}

	public Sort(String field, String type) {
		this.field = field;
		this.type = type;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
