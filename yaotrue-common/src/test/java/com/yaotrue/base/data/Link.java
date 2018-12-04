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
package com.yaotrue.base.data;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年5月19日 下午7:00:11
 */
public class Link {

	public int iData;
	
	public double dData;
	
	public Link next;
	
	public Link(int iData){
		this.iData = iData;
	}
	
	public Link(int id,double dd){
		iData = id;
		dData = dd;
	}
	
	public void display(){
		System.out.println("{" + iData + ", " + dData + "}");
	}
	
	public void displayIdata(){
		System.out.print(iData + " ");
	}
}
