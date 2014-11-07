package com.example.statechangesbroadc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyPhoneReceiver  extends BroadcastReceiver
{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.w("Called 1", "called");
		Bundle b= arg1.getExtras();
		if(b!=null){
			String state=b.getString(TelephonyManager.EXTRA_STATE);
			 Log.w("MY_DEBUG_TAG", state);
			if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
			{
				String number=b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Toast.makeText(arg0, "Call from "+number,Toast.LENGTH_SHORT).show();
				Log.d("Call from ",number+"");
			}
		}
		
	}
	
}