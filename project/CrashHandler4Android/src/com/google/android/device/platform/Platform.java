package com.google.android.device.platform;

public class Platform {

	/**
	 * 获取手机的平台信息
	 * 获取sdk version
	 */
	public static String getPlatform(){
		return "Android";
	}
	/**
	 * 获取手机的平台信息
	 * 获取sdk version
	 */
	public static int getSDKVersion(){
		return android.os.Build.VERSION.SDK_INT;
	}
}
