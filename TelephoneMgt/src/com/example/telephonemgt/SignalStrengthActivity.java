package com.example.telephonemgt;

import android.support.v7.app.ActionBarActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SignalStrengthActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signal_strength);
	    SignalStrengthListener signalStrengthListener;
	    signalStrengthListener = new SignalStrengthListener();
	   ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).listen(signalStrengthListener,SignalStrengthListener.LISTEN_SIGNAL_STRENGTHS);
		
	}
	
	
	private class SignalStrengthListener extends PhoneStateListener {
	    @Override
	    public void onSignalStrengthsChanged(
	            android.telephony.SignalStrength signalStrength) {

	        // get the signal strength (a value between 0 and 31)
	        int strengthAmplitude = signalStrength.getGsmSignalStrength();

	        // do something with it (in this case we update a text view)
	        // signalStrengthText.setText(String.valueOf(strengthAmplitude));
	        if (strengthAmplitude > 30) {
//	           Log.d("Signal","Good");
	        	Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_SHORT).show();	        	
	            // signalStrengthText.setTextColor(getResources().getColor(R.color.good));
	        } else if (strengthAmplitude > 20 && strengthAmplitude < 30) {
	        	Log.d("Signal","Average");
	        	Toast.makeText(getApplicationContext(), "Average", Toast.LENGTH_SHORT).show();
	            // signalStrengthText.setTextColor(getResources().getColor(R.color.average));
	        } else if (strengthAmplitude < 20) {
	        	Log.d("Signal","Weak");
	        	Toast.makeText(getApplicationContext(), "Weak", Toast.LENGTH_SHORT).show();
	            // signalStrengthText.setTextColor(getResources().getColor(R.color.weak));
	        }

	        super.onSignalStrengthsChanged(signalStrength);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signal_strength, menu);
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
