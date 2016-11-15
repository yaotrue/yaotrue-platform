package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class UpdateStatus {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		String statuses = "微博发布";
		Timeline tm = new Timeline(access_token);
		try {
			Status status = tm.updateStatus(statuses);
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}	
	}

}
