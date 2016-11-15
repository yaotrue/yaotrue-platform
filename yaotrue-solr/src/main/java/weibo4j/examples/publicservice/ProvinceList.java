package weibo4j.examples.publicservice;

import weibo4j.PublicService;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.util.WeiboConfig;

public class ProvinceList {

	public static void main(String[] args) {
		String access_token = WeiboConfig.getValue("access_token");
		String country = "001";
		PublicService ps = new PublicService(access_token);
		try {
			JSONArray jo = ps.provinceList(country);
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
	}

}
