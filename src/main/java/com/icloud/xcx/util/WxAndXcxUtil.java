package com.icloud.xcx.util;

public class WxAndXcxUtil {
//	 public static String gh_num = "gh_170a99a54f43";
//	 public static String appid = "wx356b2ab22ac267ed";
//	 public static String secret = "4a7166fb15d719482ea4de812bc6e15c";

     public static String gh_num = "gh_170a99a54f43";
	 public static String appid = "wx62dda7da1dd02e10";
     public static String secret = "c1b2bb134639cbd5b6971014036f4ec5";

	 public static String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	 public static String getUserInfoByOpenId = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN"; 
	 public static String getAccessToken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	 public static String getwxacodeunlimit = "http://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";
    
}
