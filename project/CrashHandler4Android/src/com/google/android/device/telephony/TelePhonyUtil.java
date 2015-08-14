package com.google.android.device.telephony;

import android.content.Context;
import android.telephony.TelephonyManager;

public class TelePhonyUtil {

	public static Phone getPhoneInfo(Context context){
		Phone phone =new Phone();
		TelephonyManager mTm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String number =mTm.getLine1Number();
		String imei =mTm.getDeviceId();
		String imsi =mTm.getSubscriberId();
		phone.setPhoneNumber(number==null?"":number);
		phone.setImei(imei == null?"":imei);
		phone.setImsi(imsi ==null?"":imsi);
		return phone;
	}
}
