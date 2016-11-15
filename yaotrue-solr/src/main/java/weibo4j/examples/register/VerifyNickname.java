package weibo4j.examples.register;

import weibo4j.Register;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class VerifyNickname {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		String nickname = "袁姗姗";
		Register reg = new Register(access_token);
		try {
			JSONObject json = reg.verifyNickname(nickname);
			System.out.println(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
