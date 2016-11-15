package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetFollowers {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		Friendships fm = new Friendships(access_token);
		String screen_name = "大爷我姓姚名真";
		try {
			UserWapper users = fm.getFollowersByName(screen_name);
			for(User u : users.getUsers()){
				Log.logInfo(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
