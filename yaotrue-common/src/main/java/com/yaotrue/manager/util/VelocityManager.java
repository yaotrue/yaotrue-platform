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
package com.yaotrue.manager.util;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年10月27日 下午4:00:15
 */
@Component
public class VelocityManager {

	private static final Logger logger = LoggerFactory.getLogger(VelocityManager.class);
	
	public static final String	DEFAULT_ENCODING	= "UTF-8";

	private boolean				initFlag			= false;

	private String				pathPrefix			= "";

	/**
	 * bean创建时，初始化velocity的参数
	 * Creates a new instance of VelocityManager.
	 */
	public VelocityManager(){
		Velocity.setProperty("resource.loader", "class");
		Velocity.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		try{
			Velocity.init();
			initFlag = true;
		}catch (Exception e){
			e.printStackTrace();
			logger.error("Init Velocity Error");
		}
	}

	public String parseVMContent(String templateContent,Map<String, Object> contextParameters){
		if (!initFlag)
			throw new RuntimeException("Velocity initialize failed");
		if (logger.isDebugEnabled()){
			logger.debug("Start parsing velocity template");
			logger.debug("Template content: " + templateContent);
			logger.debug("Parameters: " + contextParameters);
		}
		try{
			VelocityContext context = new VelocityContext();
			for (String key : contextParameters.keySet()){
				context.put(key, contextParameters.get(key));
			}
			StringWriter writer = new StringWriter();
			Velocity.evaluate(context, writer, "yaotruevm", templateContent);
			String result = writer.getBuffer().toString();
			if (logger.isDebugEnabled()){
				logger.debug("Parse result is: ");
				logger.debug(result);
			}
			return result;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("Parse Velocity Template Error");
		}
	}

	public String parseVMTemplate(String templateFileName,Map<String, Object> contextParameters){
		if (!initFlag)
			throw new RuntimeException("Velocity initialize failed");
		if (logger.isDebugEnabled()){
			logger.debug("Start parsing velocity template");
			logger.debug("Template name: " + templateFileName);
			logger.debug("Parameters: " + contextParameters);
		}
		try{
			Template template = Velocity.getTemplate(pathPrefix + templateFileName, DEFAULT_ENCODING);
			VelocityContext context = new VelocityContext();
			for (Object o : contextParameters.keySet()){
				String key = (String) o;
				context.put(key, contextParameters.get(key));
			}
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			String result = writer.getBuffer().toString();
			if (logger.isDebugEnabled()){
				logger.debug("Parse result is: ");
				logger.debug(result);
			}
			return result;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("Parse Velocity Template Error");
		}
	}

	public String getPathPrefix(){
		return pathPrefix;
	}

	public void setPathPrefix(String pathPrefix){
		this.pathPrefix = pathPrefix;
	}
}
