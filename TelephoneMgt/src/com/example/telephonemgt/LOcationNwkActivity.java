package com.example.telephonemgt;

import android.support.v7.app.ActionBarActivity;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LOcationNwkActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_nwk);
		ActionBar actionBar=getActionBar();
		actionBar.hide();
		
		String srvcName = Context.TELEPHONY_SERVICE;
		TelephonyManager telephonyManager =
				(TelephonyManager)getSystemService(srvcName);
		telephonyManager.listen(cellLocationListener,PhoneStateListener.LISTEN_CELL_LOCATION);
	
	}
	

	
	PhoneStateListener cellLocationListener = new PhoneStateListener() {
		public void onCellLocationChanged(CellLocation location) {
		if (location instanceof GsmCellLocation) {
		GsmCellLocation gsmLocation = (GsmCellLocation)location;
		Toast.makeText(getApplicationContext(),"Location "+String.valueOf(gsmLocation.getLac()),Toast.LENGTH_LONG).show();
		}
		else if (location instanceof CdmaCellLocation) {
		CdmaCellLocation cdmaLocation = (CdmaCellLocation)location;
		StringBuilder sb = new StringBuilder();
		sb.append(cdmaLocation.getBaseStationId());
		sb.append("\n@");
		sb.append(cdmaLocation.getBaseStationLatitude());
		sb.append(cdmaLocation.getBaseStationLongitude());
		Toast.makeText(getApplicationContext(),
		sb.toString(),
		Toast.LENGTH_LONG).show();
		}
		}
		};
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_nwk, menu);
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
