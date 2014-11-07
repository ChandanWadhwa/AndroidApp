package com.example.networktype;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ChannelListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class WifiDirectActivity extends ActionBarActivity {

	
	private WifiP2pManager wifiP2pManager;
	private Channel wifiDirectChannel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_direct);
		initializeWiFiDirect() ;
	
	}
	
	
	BroadcastReceiver p2pStatusReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
		int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE,
				WifiP2pManager.WIFI_P2P_STATE_DISABLED);
		switch (state) {
		case (WifiP2pManager.WIFI_P2P_STATE_ENABLED):
		Toast.makeText(getApplicationContext(), "Enable",Toast.LENGTH_SHORT).show();
		break;
		default:
			Toast.makeText(getApplicationContext(), "Disable",Toast.LENGTH_SHORT).show();
		}
		}
		};
	
	@SuppressLint("NewApi")
	private void initializeWiFiDirect() {
		wifiP2pManager =
		(WifiP2pManager)getSystemService(Context.WIFI_P2P_SERVICE);
		wifiDirectChannel = wifiP2pManager.initialize(this, getMainLooper(),
		new ChannelListener() {
		public void onChannelDisconnected() {
		initializeWiFiDirect();
		}
		}
		);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wifi_direct, menu);
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
