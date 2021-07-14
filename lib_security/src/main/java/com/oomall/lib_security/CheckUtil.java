package com.oomall.lib_security;

import java.lang.reflect.InvocationTargetException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class CheckUtil {

	/**
	 * 检测安卓程序是不是谷歌应用商店
	 *
	 * @param context
	 * @return  true 表示是谷歌应用市场
	 */
	public static boolean checkGooglePlayStore(Context context) {
		try {
			InstallSourceInfo installSourceInfo = context.getPackageManager()
					.getInstallSourceInfo(context.getPackageName());
			return installSourceInfo != null
					&& installSourceInfo.getInstallingPackageName().startsWith("com.google.android");
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 检查自己是不是运行在一台模拟器中
	 *
	 * @return  true 表示在模拟上
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmulator() {
		try {
			@SuppressLint("PrivateApi") Class systemPropertyClazz = Class .forName("android.os.SystemProperties");
			boolean kernelQemu = getProperty(systemPropertyClazz,
					"ro.kernel.qemu").length() > 0;
			boolean hardwareGoldfish = getProperty(systemPropertyClazz,
					"ro.hardware").equals("goldfish");
			boolean modelSdk = getProperty(systemPropertyClazz,
					"ro.product.model").equals("sdk");

			if (modelSdk || hardwareGoldfish || kernelQemu) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static String getProperty(Class clazz, String string)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException {
		return (String) clazz.getMethod("get", new Class[] { String.class })
				.invoke(clazz, new Object[] { string });
	}

	/**
	 * 检查app的可调式标志位是否被打开了，只有在开发阶段才应该被打开的东西
	 * @param context
	 * @return true   已被打开
	 */
	public static boolean isDebuggable(Context context) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
			return (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
		}
		return false;
	}

}
