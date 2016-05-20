/**
 * 
 */
package com.ltkj.utils;

import android.app.Activity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author hxz
 */

public class ScreenManager {
	private static Stack<Activity> activityStack;
	private static ScreenManager instance;

	private ScreenManager() {
	}

	public static ScreenManager getScreenManager() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}
	
	public Activity getLastActivity(){
		if(activityStack == null || activityStack.size() == 1){
			return null;
		}else{
			return activityStack.get(activityStack.size() - 2);
		}
	}

	/**
	 * 退出栈顶Activity
	 */
	public void popActivity() {
		if(activityStack == null || activityStack.empty()) {
			return;
		}
		Activity activity = activityStack.lastElement();
		if (activity != null) {
			activityStack.remove(activity);
			activity = null;
		}
	}
	
	public void removeActivity(Activity activity){
		if(activityStack == null || activityStack.empty()) {
			return;
		}
		if (activity != null) {
			activityStack.remove(activity);
		}
	}
	
	public Activity getFirstActivity(){
		if(activityStack == null){
			return null;
		}else{
			try{
				return activityStack.firstElement();
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
	
	
	/**
	 * 判断前一个activity是不是某个acitvity
	 * @param activity
	 * @return
	 */
	public boolean previousactivity(Activity activity){
		if(activityStack.elementAt(activityStack.size()-1) == activity){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 退出栈顶Activity
	 * @param activity
	 */
	public void popActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity = null;
		}
	}
	
	/**
	 * @描述:退出activity
	 * @方法名: popActivity
	 * @param cls
	 * @返回类型 void
	 */
	public void popActivity(Class<?> cls){
		if(cls != null){
			if(activityStack != null){
				Iterator<Activity> iterator = activityStack.iterator();
				while(iterator.hasNext()){
					Activity activity = iterator.next();
					if(activity == null){
						iterator.remove();
					}else if(activity.getClass().equals(cls)){
						iterator.remove();
						activity.finish();
						break;
					}
				}
			}
		}
	}

	/**
	 * 获得当前栈顶Activity
	 * @return
	 */
	public Activity currentActivity() {
		if(activityStack == null || activityStack.empty()) {
			return null;
		}
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 将当前Activity推入栈中
	 * @param activity
	 */
	public void pushActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 退出栈中所有Activity，指定Activity除外
	 * @param cls
	 */
	public void popAllActivityExceptOne(Class<?> cls) {
		if(activityStack != null){
			Iterator<Activity> iterator = activityStack.iterator();
			while(iterator.hasNext()){
				Activity activity = iterator.next();
				if(activity == null){
					iterator.remove();
				}else if(activity.getClass().equals(cls)){
					continue;
				}else{
					iterator.remove();
					activity.finish();
				}
			}
		}
	}
	/**
	 * 退出栈中所有Activity，指定Activitys除外
	 * @param cls
	 */
	public void popAllActivityExceptOhters(Class<?>... cls) {
		if(activityStack != null){
			List<Class<?>> clss = Arrays.asList(cls);
			Iterator<Activity> iterator = activityStack.iterator();
			while(iterator.hasNext()){
				Activity activity = iterator.next();
				if(activity == null){
					iterator.remove();
				}else if(clss.contains(activity.getClass())){
					continue;
				}else{
					iterator.remove();
					activity.finish();
				}
			}
		}
	}
	/**
	 * 
	 * @描述: 移除某个之后的Activity,如 A->B->C-D->E,移除C之后的Activity,执行后结果：A->B->C
	 * @方法名: popAllActivityAfter
	 * @param cls
	 * @返回类型 void
	 */
	public void popAllActivityAfter(Class<?> cls){
		if(activityStack != null){
			while (true) {
				Activity activity = activityStack.lastElement();
				if(activity != null){
					if(activity.getClass().equals(cls)){
						break;
					}else{
						activityStack.pop();
						activity.finish();
					}
				}else{
					activityStack.pop();
				}
			}
		}
	}

	/**
	 * 退出栈中所有Activity
	 */
	public void popAllActivity() {
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			popActivity(activity);
			activity.finish();
		}
	}
}
