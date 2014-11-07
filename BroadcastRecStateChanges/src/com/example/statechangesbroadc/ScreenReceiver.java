package com.example.statechangesbroadc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class ScreenReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
//		Handler handler = new Handler(); 
//		handler.postDelayed(new Runnable() { 
//     	public void run() { 
////     		Toast.makeText(context, "Broadcast Receiver called", Toast.LENGTH_SHORT).show();
//     		Log.d("Intent called " , "Custom Intent");
//
//     } 
//}, 3000);
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask()
		{
		    @Override
		    public void run()
		    {
//		    	Log.d("Intent called " , "Custom Intent");
		    	new HttpAsyncTask().execute();
		    }},1000, 5000);
	
	
		
	}
	
	
	 class HttpAsyncTasks extends AsyncTask<String, Void, String>
		{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
		
			return null;
		}
		
		}
	 
//	 private RunningAppProcessInfo getForegroundApp() {
//		 RunningAppProcessInfo result = null, info = null;
//
//		 final ActivityManager activityManager  =  (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
//
//		 List <RunningAppProcessInfo> l = activityManager.getRunningAppProcesses();
//		 Iterator <RunningAppProcessInfo> i = l.iterator();
//		 while(i.hasNext()) {
//		     info = i.next();
//		     if(info.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND
//		             && !isRunningService(info.processName)) {
//		         result = info;
//		         break;
//		     }
//		 }
//		 return result;
//		 }
	 
//	 private boolean isRunningService(String processName) {
//		 if(processName == null)
//		     return false;
//
//		 RunningServiceInfo service;
//
//		 final ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
//
//		 List <RunningServiceInfo> l = activityManager.getRunningServices(9999);
//		 Iterator <RunningServiceInfo> i = l.iterator();
//		 while(i.hasNext()){
//		     service = i.next();
//		     if(service.process.equals(processName))
//		         return true;
//		 }
//		 return false;
//		 }
//	 
	 
//	 private boolean isRunningApp(String processName) {
//		 if(processName == null)
//		     return false;
//
//		 RunningAppProcessInfo app;
//
//		 final ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
//
//		 List <RunningAppProcessInfo> l = activityManager.getRunningAppProcesses();
//		 Iterator <RunningAppProcessInfo> i = l.iterator();
//		 while(i.hasNext()){
//		     app = i.next();
//		     if(app.processName.equals(processName) && app.importance != RunningAppProcessInfo.IMPORTANCE_SERVICE)
//		         return true;
//		 }
//		 return false;
//		 }
	 
//	 private boolean checkifThisIsActive(RunningAppProcessInfo target){
//		 boolean result = false;
//		 ActivityManager.RunningTaskInfo info;
//
//		 if(target == null)
//		     return false;
//
//		 final ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
//
//		 List <ActivityManager.RunningTaskInfo> l = activityManager.getRunningTasks(9999);
//		 Iterator <ActivityManager.RunningTaskInfo> i = l.iterator();
//
//		 while(i.hasNext()){
//		     info=i.next();
//		     if(info.baseActivity.getPackageName().equals(target.processName)) {
//		         result = true;
//		         break;
//		     }
//		 }
//
//		 return result;
//		 } 
	 
	 public static Collection subtractSets(Collection a, Collection b)
	 {
	 Collection result = new ArrayList(b);
	 result.removeAll(a);
	 return result;
	 }

	
	
	 class HttpAsyncTask extends AsyncTask<String, Void, String>
		{

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				try
				{
				    Process mLogcatProc = null;
				    BufferedReader reader = null;
				    mLogcatProc = Runtime.getRuntime().exec(new String[]{"logcat", "-d"});

				    reader = new BufferedReader(new InputStreamReader(mLogcatProc.getInputStream()));

				    String line;
				    final StringBuilder log = new StringBuilder();
				    String separator = System.getProperty("line.separator"); 

				    while ((line = reader.readLine()) != null)
				    {
				        log.append(line);
				        log.append(separator);
				    }
				    String w = log.toString();
//				    Toast.makeText(getApplicationContext(),w, Toast.LENGTH_LONG).show();
				    Log.d("Run ",w);
				}
				catch (Exception e) 
				{
//				    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
				}
				
				return null;
			}
		}
	
}