<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp/simple-api"%>
<!DOCTYPE html>
<html lang="en">
	<body>
		<form action="/testCaptch" method="get">
		
			<botDetect:simpleCaptcha id="basicExample"/>
			<div style="width:100px;height: 100px;"></div>
			<input name="captchaCode" type="text" id="captchaCode" value="${basicExample.captchaCode}" />
        	<input type="submit" name="validateCaptchaButton" value="提交" id="validateCaptchaButton" />
			<p>
			${basicExample.captchaCorrect}<br/>
			${basicExample.captchaIncorrect}
			</p>
		</form>	
	</body>
</html>