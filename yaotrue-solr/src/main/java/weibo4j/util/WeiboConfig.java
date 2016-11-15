package weibo4j.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class WeiboConfig {
	public WeiboConfig(){}
	private static Properties props = new Properties(); 
	static{
		try {
			Resource resource = new ClassPathResource("weibo_config.properties");
			props.load(resource.getInputStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return props.getProperty(key);
	}

    public static void updateProperties(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
