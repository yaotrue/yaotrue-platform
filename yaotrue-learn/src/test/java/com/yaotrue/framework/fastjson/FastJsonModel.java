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
package com.yaotrue.framework.fastjson;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月1日 上午9:58:53
 */
public class FastJsonModel {

	@JSONField(name="ID")
	private Long id;
	
	private String name;
	
	private Double score;
	
	private Float float1;
	
	@JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date birthDay;
	
	private BigDecimal bigDecimal;
	
	@JSONField(serialize=true)
	private List<String> listStr;
	
	private Map<String, Integer> map;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the float1
	 */
	public Float getFloat1() {
		return float1;
	}

	/**
	 * @param float1 the float1 to set
	 */
	public void setFloat1(Float float1) {
		this.float1 = float1;
	}

	/**
	 * @return the birthDay
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return the bigDecimal
	 */
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	/**
	 * @param bigDecimal the bigDecimal to set
	 */
	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}

	/**
	 * @return the listStr
	 */
	public List<String> getListStr() {
		return listStr;
	}

	/**
	 * @param listStr the listStr to set
	 */
	public void setListStr(List<String> listStr) {
		this.listStr = listStr;
	}

	/**
	 * @return the map
	 */
	public Map<String, Integer> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
}
