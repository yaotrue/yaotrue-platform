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
package com.yaotrue.web.command;

import java.io.Serializable;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2018年4月27日 上午11:09:33
 */
public class BasicExample implements Serializable {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = -7109624151571172708L;

	private String captchaCode, captchaCorrect, captchaIncorrect;

	public String getCaptchaCode() {
		return captchaCode;
	}

	public void setCaptchaCode(String userCaptchaCode) {
		this.captchaCode = userCaptchaCode;
	}

	public String getCaptchaCorrect() {
		return captchaCorrect;
	}

	public void setCaptchaCorrect(String captchaCorrect) {
		this.captchaCorrect = captchaCorrect;
	}

	public String getCaptchaIncorrect() {
		return captchaIncorrect;
	}

	public void setCaptchaIncorrect(String captchaIncorrect) {
		this.captchaIncorrect = captchaIncorrect;
	}
}
