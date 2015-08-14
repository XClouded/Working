package com.google.android.device.operator;

import android.content.Context;
import android.telephony.TelephonyManager;

public class Operator {

	public static String getOperatorInfo(Context context)
	{
		TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		String operatorString = telephonyManager.getSimOperator();
		if(operatorString == null)
		{
			return "Unknow";
		}
		if(operatorString.equals("46000") || operatorString.equals("46002"))
		{
			//中国移动
			return "中国移动";
		}
		else if(operatorString.equals("46001"))
		{
			//中国联通
			return "中国联通";
		}
		else if(operatorString.equals("46003"))
		{
			//中国电信
			return "中国电信";
		}
		return "Unknow";
	}

}
