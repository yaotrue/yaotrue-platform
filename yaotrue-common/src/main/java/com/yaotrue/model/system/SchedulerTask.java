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
package com.yaotrue.model.system;

import com.yaotrue.model.BaseModel;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a> 2016年10月27日
 *         上午11:22:09
 */
public class SchedulerTask extends BaseModel {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = 2202800656161599250L;

	/**
	 * PK
	 */
	private Long id;

	/**
	 * 任务编码,如： SYS_SCHEDULER_ORDER_SEND
	 */
	private String code;

	/**
	 * quartz时间表达式
	 */
	private String timeExp;

	/**
	 * 任务描述
	 */
	private String description;

	/**
	 * spring容器中通过beanName来找到实例
	 */
	private String beanName;

	/**
	 * 定时调用的方法
	 */
	private String methodName;

	/**
	 * 生命周期
	 */
	private Integer lifecycle;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the timeExp
	 */
	public String getTimeExp() {
		return timeExp;
	}

	/**
	 * @param timeExp
	 *            the timeExp to set
	 */
	public void setTimeExp(String timeExp) {
		this.timeExp = timeExp;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the beanName
	 */
	public String getBeanName() {
		return beanName;
	}

	/**
	 * @param beanName
	 *            the beanName to set
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName
	 *            the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return the lifecycle
	 */
	public Integer getLifecycle() {
		return lifecycle;
	}

	/**
	 * @param lifecycle
	 *            the lifecycle to set
	 */
	public void setLifecycle(Integer lifecycle) {
		this.lifecycle = lifecycle;
	}

}
