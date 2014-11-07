package com.example.broadcastcustom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OutgoingReceiver extends BroadcastReceiver {
 
    public static final String CUSTOM_INTENT = "jason.wei.custom.intent.action.TEST";
 
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("HIT OUTGOING");
        Intent i = new Intent();
        i.setAction(CUSTOM_INTENT);
        context.sendBroadcast(i);
    }
 
}
