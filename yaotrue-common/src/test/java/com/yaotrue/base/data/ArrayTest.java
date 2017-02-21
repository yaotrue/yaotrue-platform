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
 * 2016年11月23日 上午9:29:29
 */
public class ArrayTest {

	private Integer[] numArray = new Integer[0];
	
	public void addElementToArray(Integer num){
		Integer[] newNumArray = new Integer[numArray.length+1];
		
		for(int i=0;i<numArray.length;i++){
			newNumArray[i] = numArray[i];
		}
		
		newNumArray[numArray.length] = num;
		
		numArray = newNumArray;
	}
	
	public void shoNumArray(){
		System.out.println();
		for(int i=0;i<numArray.length;i++){
			System.out.print(numArray[i]+" ");
		}
	}
	
	public void removeElementOnArray(Integer num){
		Integer[] newNumArray = new Integer[numArray.length-1];
		
		int index = -1;
		for(int i=0;i<numArray.length;i++){
			if(num.intValue() == numArray[i]){
				index = i;
				break;
			}
		}
		
		if(index < 0){
			return;
		}
		
		int j=0;
		for(int i=0;i<numArray.length;i++){
			if(i == index){
				continue;
			}
			
			newNumArray[j++] = numArray[i];
		}
		
		numArray = newNumArray;
	}
	
	
	@Test
	public void testArray(){
		shoNumArray();
		
		addElementToArray(10);
		addElementToArray(34);
		addElementToArray(6);
		
		shoNumArray();
		
		addElementToArray(67);
		addElementToArray(23);
		
		shoNumArray();
		
		removeElementOnArray(6);
		
		shoNumArray();
	}
}
