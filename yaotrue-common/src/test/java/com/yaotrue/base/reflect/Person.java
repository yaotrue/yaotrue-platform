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
package com.yaotrue.base.reflect;

import java.io.Serializable;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年5月25日 下午1:49:43
 */
public class Person implements Speak,Serializable {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = -3213155224723924956L;

	private String name;
	
	private int age;
	
	/**
	 * Creates a new instance of Person.
	 */
	public Person() {
	}
	
	/**
	 * Creates a new instance of Person.
	 * @param name
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * Creates a new instance of Person.
	 * @param name
	 * @param age
	 */
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.name + " " + this.age + "]";
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.base.reflect.Speak#sayHello()
	 */
	public String sayHello() {
		return "你好，我的名字叫"+name;
	}
	
	public static final synchronized String testShowMethodName() throws RuntimeException {
		return "test xxxxx";
	}
}
