package com.example.networktype;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		String service = Context.CONNECTIVITY_SERVICE;
//		ConnectivityManager connectivity =(ConnectivityManager)getSystemService(service);
//		NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
//		boolean isConnected = ((activeNetwork != null) &&	(activeNetwork.isConnectedOrConnecting()));
//		if(isConnected)
//		{
//		boolean isWiFi = activeNetwork.getType() ==ConnectivityManager.TYPE_WIFI;
//		if(activeNetwork.getType() ==ConnectivityManager.TYPE_WIFI)
//		{
//			Toast.makeText(getApplicationContext(), "Connect to Wifi",Toast.LENGTH_SHORT).show();
//		}
//		else if (activeNetwork.getType() ==ConnectivityManager.TYPE_MOBILE)
//		{
//			Toast.makeText(getApplicationContext(), "Connect to Mobile Data",Toast.LENGTH_SHORT).show();
//		}
//		}
		
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
