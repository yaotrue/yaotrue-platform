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
 * 2016年5月20日 下午1:11:57
 */
public class SortedList {

	private Link first;
	
	public SortedList(){
		first = null;
	}
	
	public void insert(int idata){
		Link link = new Link(idata);
		Link current = first;
		Link previous = null;
		
		while (current != null && idata > current.iData) {
			current = current.next;
			previous = current;
		}
		
		if (previous == null) {
			first = link;
		}else{
			previous.next = link;
		}
		
		link.next = current;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public Link delete(){
		if (isEmpty()) {
			return null;
		}
		Link temp = first;
		first = first.next;
		return temp;
	}
}
