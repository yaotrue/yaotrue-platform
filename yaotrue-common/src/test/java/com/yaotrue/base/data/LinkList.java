/**
 * Copyright (c) 2012 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.yaotrue.base.data;

import org.junit.Test;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年5月19日 下午7:04:26
 */
public class LinkList {

	private Link first;
	
	public LinkList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(int id,double dd){
		Link link = new Link(id, dd);
		link.next = first;
		first = link;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		Link current = first;
		
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
	
	@Test
	public void testLink(){
		LinkList linkList = new LinkList();
		linkList.insertFirst(1, 12.34);
		linkList.insertFirst(2, 34.23);
		linkList.insertFirst(3, 45.23);
		linkList.insertFirst(4, 89.34);
		linkList.insertFirst(5, 23.11);
		
		linkList.displayList();
		System.out.println("---------------");
		while (!linkList.isEmpty()) {
			linkList.deleteFirst();
			linkList.displayList();
			System.out.println("---------------");
		}
	}
	
	@Test
	public void testData(){
		boolean falg = false;
		char c = 'a';
		byte b = 124;
		short s = 100;
		int i = 1000;
		long l = 2000l;
		float f = 12.3f;
		double d = 3.141592;
	}
}
