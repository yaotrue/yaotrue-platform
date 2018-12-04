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
package com.yaotrue.framework.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年8月31日 下午2:54:47
 */
public class Person {

	private String name;
	
	private List<String> yhk;
	
	private Set<Double> price;
	
	private Integer[] num;
	
	private Map<String, Double> yhkPrice;
	
	private Properties properties;

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
	 * @return the yhk
	 */
	public List<String> getYhk() {
		return yhk;
	}

	/**
	 * @param yhk the yhk to set
	 */
	public void setYhk(List<String> yhk) {
		this.yhk = yhk;
	}

	/**
	 * @return the price
	 */
	public Set<Double> getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Set<Double> price) {
		this.price = price;
	}

	/**
	 * @return the num
	 */
	public Integer[] getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(Integer[] num) {
		this.num = num;
	}

	/**
	 * @return the yhkPrice
	 */
	public Map<String, Double> getYhkPrice() {
		return yhkPrice;
	}

	/**
	 * @param yhkPrice the yhkPrice to set
	 */
	public void setYhkPrice(Map<String, Double> yhkPrice) {
		this.yhkPrice = yhkPrice;
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
