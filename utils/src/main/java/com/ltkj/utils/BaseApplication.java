package com.ltkj.utils;


import android.app.Application;

/**
 * @author hedewen
 * @time 2014年12月9日 下午1:35:15
 */
public class BaseApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		// 异常日志捕捉
		AbnormalHandler crashHandler = AbnormalHandler.getInstance();
		crashHandler.init(getApplicationContext());	
		appName = getResources().getString(R.string.app_name);
	}
	
	private static String appName;

	public static String getAppName() {
		return ConvertUtils.Obj2Str(appName);
	}
}
