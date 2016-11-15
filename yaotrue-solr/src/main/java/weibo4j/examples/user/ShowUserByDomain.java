package weibo4j.examples.user;

import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class ShowUserByDomain {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		String domain = "dashabiyz";
		Users um = new Users(access_token);
		try {
			User user = um.showUserByDomain(domain);
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
