package com.google.android.device.crashhandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.util.Log;

import com.google.android.device.appversion.AppVersion;
import com.google.android.device.brand.Brand;
import com.google.android.device.network.NetWork;
import com.google.android.device.operator.Operator;
import com.google.android.device.platform.Platform;
import com.google.android.device.telephony.TelePhonyUtil;

public class CrashHandler implements UncaughtExceptionHandler{
	
	private String TAG =this.getClass().getSimpleName();
	private Context context =null;
	private static CrashHandler instance;
	private CrashHandler(){
		
	}
	private UncaughtExceptionHandler mHandler;
	public static CrashHandler getInstance(){
		if(instance ==null){
			synchronized (CrashHandler.class) {
				if(instance ==null){
					instance =new CrashHandler();
				}
			}
		}
		return instance;
	}
	
	public void crashHandlerRegister(Context context){
		this.context =context;
		mHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}
	
	public void crashHandlerUnregister(){
		Thread.setDefaultUncaughtExceptionHandler(mHandler);
	}
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		if(e!=null){
			StringWriter sw =new StringWriter();
			PrintWriter pw =new PrintWriter(sw, true);
			e.printStackTrace(pw);
			String crashMessage =sw.toString();
			Log.e(TAG, "appVersion:"+AppVersion.getVersion(context));
			Log.e(TAG, "netWork:"+NetWork.getNetWorkInfo(context));
			Log.e(TAG, "brand:"+Brand.getManufacturer()+ " "+Brand.getModel(context));
			Log.e(TAG, "operator:"+Operator.getOperatorInfo(context));
			Log.e(TAG, "platform:"+Platform.getPlatform() + " "+Platform.getSDKVersion());
			Log.e(TAG, "telephoy:"+TelePhonyUtil.getPhoneInfo(context).getImei() +" "+TelePhonyUtil.getPhoneInfo(context).getImsi() +TelePhonyUtil.getPhoneInfo(context).getPhoneNumber());
			Log.e(TAG, crashMessage);
		}
	}
}
