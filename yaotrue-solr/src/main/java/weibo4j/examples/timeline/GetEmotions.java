package weibo4j.examples.timeline;

import java.util.List;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Emotion;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetEmotions {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		Timeline tm = new Timeline(access_token);
		try {
			List<Emotion> emotions =  tm.getEmotions();
			for(Emotion e : emotions){
				Log.logInfo(e.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
