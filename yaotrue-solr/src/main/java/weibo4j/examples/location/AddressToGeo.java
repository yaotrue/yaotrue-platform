package weibo4j.examples.location;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import weibo4j.Location;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Geos;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class AddressToGeo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String access_token = WeiboConfig.getValue("access_token");
		String address = URLEncoder.encode("上海市闸北区万荣路共和新路1000号", "UTF-8");
		Location l = new Location(access_token);
		try {
			List<Geos> list = l.addressToGeo(address);
			for (Geos g : list) {
				Log.logInfo(g.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
