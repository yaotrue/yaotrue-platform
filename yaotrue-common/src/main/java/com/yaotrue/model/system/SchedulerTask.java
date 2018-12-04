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
package com.yaotrue.model.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.yaotrue.model.BaseModel;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年10月27日
 *         上午11:22:09
 */
@Entity  
@Table(name = "T_YT_SCHEDULER_TASK") 
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
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_T_YZ_SCHEDULER_TASK",sequenceName = "S_T_YZ_SCHEDULER_TASK",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_T_YZ_SCHEDULER_TASK")
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
	@Column(name = "CODE",length = 100)
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
	@Column(name = "TIME_EXP",length = 50)
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
	@Column(name = "DESCRIPTION",length = 100)
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
	@Column(name = "BEAN_NAME",length = 100)
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
	@Column(name = "METHOD_NAME",length = 100)
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
	@Column(name = "LIFECYCLE")
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
