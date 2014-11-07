package com.example.telephonemgt;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		PackageManager pm = getPackageManager();
		boolean telephonySupported =
		pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
		if(telephonySupported)
		{
			Log.d("Phone Feature","Dialining Available");
		}
		boolean gsmSupported =
		pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
		if(gsmSupported)
		{
			Log.d("Phone Feature","Gsm Option");
		}
		boolean cdmaSupported =
		pm.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);
		if(cdmaSupported)
		{
			Log.d("Phone Feature","CDMA Option");
		}
		String srvcName = Context.TELEPHONY_SERVICE;
		TelephonyManager telephonyManager =
				(TelephonyManager)getSystemService(srvcName);
		String phoneNumber = telephonyManager.getLine1Number();
		Log.d("Phone No ", phoneNumber);
		String simCountry = telephonyManager.getSimCountryIso();
		Log.d("ISO Code ",simCountry);		
		// Get the operator code of the active SIM (MCC + MNC)
		String simOperatorCode = telephonyManager.getSimOperator();
		Log.d("Operator Code ",simOperatorCode);
		// Get the name of the SIM operator
		String simOperatorName = telephonyManager.getSimOperatorName();
		Log.d("Operator Name ",simOperatorName);
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
