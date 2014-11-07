package com.example.gmapintegration;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final LatLng TutorialsPoint = new LatLng(21 , 57);
	private GoogleMap googleMap;
	GPSTracker gps;
	
	
	double latitude;
	double longitude;
	LatLng currentloc;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 gps = new GPSTracker(MainActivity.this);

			// check if GPS enabled		
	        if(gps.canGetLocation()){
	        	
	        	latitude = gps.getLatitude();
	        	longitude = gps.getLongitude();
	        	currentloc = new LatLng(latitude, longitude);
	        }
		

		try { 
            if (googleMap == null) {
               googleMap = ((MapFragment) getFragmentManager().
               findFragmentById(R.id.map)).getMap();
            }
         googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
         
         
         // Changing marker icon
        	    Marker kiel = googleMap.addMarker(new MarkerOptions()
        	        .position(currentloc)
        	        .title("Kiel")
        	        .snippet("Kiel is cool")
        	        .icon(BitmapDescriptorFactory
        	            .fromResource(R.drawable.ic_launcher)));

        	    // Move the camera instantly to currentloc with a zoom of 100.
        	    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentloc, 100));

        	    // Zoom in, animating the camera.
        	    googleMap.animateCamera(CameraUpdateFactory.zoomTo(5), 2000, null);
         
         
         
         
      // create marker
         MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps");
    
         googleMap.setMyLocationEnabled(true);
         Marker TP = googleMap.addMarker(new MarkerOptions().
         position(TutorialsPoint).title("TutorialsPoint"));

      } catch (Exception e) {
         e.printStackTrace();
      }
	}

	
}
