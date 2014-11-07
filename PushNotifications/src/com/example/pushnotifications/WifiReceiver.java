package com.example.pushnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiReceiver extends BroadcastReceiver {

	NotificationManager NM;
		   @SuppressWarnings("deprecation")
		@Override
		   public void onReceive(Context context, Intent intent) {

		      NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
		      if(info != null) {
		         if(info.isConnected()) {
		            // Do your work. 
		        	 NM=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		     		@SuppressWarnings("deprecation")
		     		Notification notify=new Notification(android.R.drawable.
		     			      stat_notify_more,"Notify",System.currentTimeMillis());
		     		
		     		PendingIntent pending=PendingIntent.getActivity(
		     			      context.getApplicationContext(),0, new Intent(),0);
		     		notify.setLatestEventInfo(context.getApplicationContext(),"New Notification","Notification by chandan",pending);
		     		NM.notify(0, notify);

		            // e.g. To check the Network Name or other info:
		            WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		            String ssid = wifiInfo.getSSID();
		            Log.d("Connect to Wifi ",ssid);
		         }
		      }
		   }
		   
}
