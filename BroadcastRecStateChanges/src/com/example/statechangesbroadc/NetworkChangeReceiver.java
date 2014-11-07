package com.example.statechangesbroadc;

import java.util.jar.Attributes.Name;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isConnected ;
        WifiManager wifi;
        String name="";
        
        wifi = (WifiManager)context.getSystemService(context.WIFI_SERVICE);
        
        ConnectivityManager networkConnectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        final NetworkInfo networkInfo = networkConnectivity.getActiveNetworkInfo();
        if(wifi.isWifiEnabled())
        {
        	WifiInfo wifiInfo = wifi.getConnectionInfo();
        	 name =wifiInfo.getSSID();
        	
        }

        if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
        {
            isConnected = true;
            
            Toast.makeText(context, "Connected to Wi-Fi "+name,Toast.LENGTH_SHORT ).show();
        }
        else
        {
            isConnected = false;
            
        }
    }
}