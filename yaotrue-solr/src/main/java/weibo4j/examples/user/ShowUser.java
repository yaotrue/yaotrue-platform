package weibo4j.examples.user;

import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class ShowUser {

	public static void main(String[] args) {
		/*String access_token = args[0];
		String uid = args[1];
		Users um = new Users(access_token);
		try {
			User user = um.showUserById(uid);
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}*/
		
		String access_token = WeiboConfig.getValue("access_token");
	    String uid = "3865219173";
	    Users um = new Users(access_token);
	    try {
	        User user = um.showUserById(uid);
	        Log.logInfo(user.toString());
	    } catch (WeiboException e) {
	        e.printStackTrace();
	    }
	}
}
