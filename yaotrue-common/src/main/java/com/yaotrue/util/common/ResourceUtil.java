/*
 * Copyright 1999-2017 YaoTrue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaotrue.util.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年4月27日 上午10:10:30
 */
public class ResourceUtil {

	/**
	 * 获取资源流
	 * @param resourceName
	 * @return
	 */
	public static InputStream getResourceAsStream(String resourceName) {
        return getResourceAsStream(resourceName,null);
    }

	/**
	 * 获取资源流
	 * @param resourceName
	 * @param callingClass
	 * @return
	 */
	public static InputStream getResourceAsStream(String resourceName, Class<?> callingClass) {
        URL url = getResource(resourceName, callingClass);
        try {
            return (url != null) ? url.openStream() : null;
        } catch (IOException e) {
            return null;
        }
    }
	
	/**
	 * 获取资源URL
	 * @param resourceName
	 * @return
	 */
	public static URL getResource(String resourceName) {
        return getResource(resourceName, null);
    }
		
	/**
	 * 获取资源URL
	 * @param resourceName
	 * @param callingClass
	 * @return
	 */
	public static URL getResource(String resourceName, Class<?> callingClass) {
        URL url = null;
        url = Thread.currentThread().getContextClassLoader().getResource(resourceName);
        if (url == null) {
            url = ResourceUtil.class.getClassLoader().getResource(resourceName);
        }
        if (url == null && callingClass != null) {
            url = callingClass.getClassLoader().getResource(resourceName);
        }
        return url;
    }
}
