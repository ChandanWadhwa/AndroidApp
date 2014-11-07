package com.example.statechangesbroadc;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class CustomBroadcast extends Activity {

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		mReceiver=new ScreenReceiver();
//		filter=new IntentFilter("com.example.statechangesbroadc.USER_ACTION");
		
		registerReceiver(mReceiver, filter);
	}

	ScreenReceiver mReceiver;
	IntentFilter filter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_broadcast);
		
		mReceiver=new ScreenReceiver();
		filter=new IntentFilter("com.example.statechangesbroadc.USER_ACTION");
		Intent intnet = new Intent("com.example.statechangesbroadc.USER_ACTION");
        sendBroadcast(intnet);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.custom_broadcast, menu);
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
