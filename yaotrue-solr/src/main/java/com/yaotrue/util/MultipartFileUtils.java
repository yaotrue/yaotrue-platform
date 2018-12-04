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
package com.yaotrue.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年11月1日 下午1:56:59
 */
public class MultipartFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(MultipartFileUtils.class);

	public static InputStream getFirstFileInputStream(HttpServletRequest request) {
		if (request == null)
			return null;
		if (!(request instanceof MultipartHttpServletRequest))
			return null;

		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = req.getFileMap();

		if (fileMap == null || fileMap.isEmpty())
			return null;

		try {
			return ((MultipartFile) CollectionUtils.get(fileMap.values(), 0)).getInputStream();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);

			return null;
		}
	}

	public static String getFirstFileName(HttpServletRequest request) {
		if (request == null)
			return null;
		if (!(request instanceof MultipartHttpServletRequest))
			return null;

		MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = req.getFileMap();

		if (fileMap == null || fileMap.isEmpty())
			return null;

		return ((MultipartFile) CollectionUtils.get(fileMap.values(), 0)).getOriginalFilename();

	}

	/**
	 * 写文件 保存 后返回文件路径， 返回类型：String
	 */
	public static File saveFile(HttpServletRequest request, String path,String fileName) {
		InputStream inputStream = MultipartFileUtils.getFirstFileInputStream(request);
		File pathFile = new File(path);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		File file = new File(path + fileName);
		file.setReadable(true);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			byte[] array = new byte[1000];
			while (inputStream.available() > 0) {
				inputStream.read(array);
				out.write(array);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return file;
	}
}
