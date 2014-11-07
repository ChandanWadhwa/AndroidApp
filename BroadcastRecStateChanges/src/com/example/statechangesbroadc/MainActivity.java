package com.example.statechangesbroadc;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=this;
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
	
//	public class MyPhoneReceiver extends BroadcastReceiver
//	{
//
//		@Override
//		public void onReceive(Context arg0, Intent arg1) {
//			// TODO Auto-generated method stub
//			Log.w("Called 1", "called");
//			Bundle b= arg1.getExtras();
//			if(b!=null){
//				String state=b.getString(TelephonyManager.EXTRA_STATE);
//				 Log.w("MY_DEBUG_TAG", state);
//				if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
//				{
//					String number=b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
//					Toast.makeText(context, "Call from "+number,Toast.LENGTH_SHORT).show();
//					Log.d("Call from ",number+"");
//				}
//			}
//			
//		}
//		
//	}
}
