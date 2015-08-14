package com.google.android.device.brand;

import android.content.Context;

public class Brand {
	
	public static String getModel(Context context){
		return android.os.Build.MODEL;
	}
	
	public static String getManufacturer(){
		return android.os.Build.MANUFACTURER;
	}
}
