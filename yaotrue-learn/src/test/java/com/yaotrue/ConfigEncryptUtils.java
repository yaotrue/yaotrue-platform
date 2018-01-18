package com.yaotrue;

import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class ConfigEncryptUtils {
	private static final StandardPBEStringEncryptor ENCRYPTOR = new StandardPBEStringEncryptor();
	static {
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		// config.setAlgorithm("PBEWithMD5AndDES");
		config.setProvider(new BouncyCastleProvider());
		config.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
		// 自己在用的时候更改此密码 
		config.setPassword("GBvYJbcwdtc4CfwIAcaEN0rQhRXmPTJ4vsZC0TK1sanG4ULiAPFQ4XR1w85Vw3h2");

		//获取jdk支持的密码学算法
		Provider[] providers = Security.getProviders();
		for (Provider provider : providers) {
			 //System.out.println(provider.getInfo());
			Set<Provider.Service> services = provider.getServices();
			for (Service service : services) {
//				System.out.println(service.getAlgorithm());
			}
		}

		ENCRYPTOR.setConfig(config);
	}
	public static void main(String[] args) {
		System.out.println("加密："+ENCRYPTOR.encrypt("yz"));
		System.out.println("解密："+ENCRYPTOR.decrypt("YoCvANAEqSBAM+dXT6yipk/BgsiB5/v9L9jguVwwDo8="));
	}
}
