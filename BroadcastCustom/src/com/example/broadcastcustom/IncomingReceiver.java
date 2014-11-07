package com.example.broadcastcustom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class IncomingReceiver extends BroadcastReceiver {
 
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(OutgoingReceiver.CUSTOM_INTENT)) {
//            System.out.println("GOT THE INTENT");
        	Toast.makeText(context, "GOT THE INTENT", Toast.LENGTH_SHORT).show();
        }
    }
}