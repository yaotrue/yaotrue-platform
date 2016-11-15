package weibo4j.examples.location;

import weibo4j.Location;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class GetMapImage {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		String city = "1000";
		Location l = new Location(access_token);
		try {
			JSONObject json = l.getMapImageByCity(city);
			Log.logInfo(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
