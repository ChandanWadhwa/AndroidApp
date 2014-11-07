package com.example.pushnotifications;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

//	NotificationManager NM;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		NM=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//		@SuppressWarnings("deprecation")
//		Notification notify=new Notification(android.R.drawable.
//			      stat_notify_more,"Notify",System.currentTimeMillis());
//		
//		PendingIntent pending=PendingIntent.getActivity(
//			      getApplicationContext(),0, new Intent(),0);
//		notify.setLatestEventInfo(getApplicationContext(),"New Notification","Notification by chandan",pending);
//		NM.notify(0, notify);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
		   

		

	
}
