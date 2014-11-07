package com.example.networktype;

import java.util.jar.Attributes.Name;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

	NotificationManager NM;
    @Override
    public void onReceive(Context context, Intent intent) {
    	String service = Context.CONNECTIVITY_SERVICE;
		ConnectivityManager connectivity =(ConnectivityManager)context.getSystemService(service);
		 NM=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
		boolean isConnected = ((activeNetwork != null) &&	(activeNetwork.isConnectedOrConnecting()));
		if(isConnected)
		{
		boolean isWiFi = activeNetwork.getType() ==ConnectivityManager.TYPE_WIFI;
		if(activeNetwork.getType() ==ConnectivityManager.TYPE_WIFI)
		{
			Toast.makeText(context.getApplicationContext(), "Connected to Wifi",Toast.LENGTH_SHORT).show();
     		Notification notify=new Notification(android.R.drawable.
   			      stat_notify_more,"Notify",System.currentTimeMillis());
   		
   		PendingIntent pending=PendingIntent.getActivity(context.getApplicationContext(),0, new Intent(),0);
   		notify.setLatestEventInfo(context.getApplicationContext(),"New Notification","Connected to Wifi",pending);
   		NM.notify(0, notify);
		}
		else if (activeNetwork.getType() ==ConnectivityManager.TYPE_MOBILE)
		{
			Toast.makeText(context.getApplicationContext(), "Connected to Mobile Data",Toast.LENGTH_SHORT).show();
			Notification notify=new Notification(android.R.drawable.
	   			      stat_notify_more,"Notify",System.currentTimeMillis());
	   		
	   		PendingIntent pending=PendingIntent.getActivity(context.getApplicationContext(),0, new Intent(),0);
	   		notify.setLatestEventInfo(context.getApplicationContext(),"New Notification","Connected to Mobile Data",pending);
	   		NM.notify(0, notify);
		}
		}
    }
}