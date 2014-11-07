package com.example.statechangesbroadc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class RunningAppTrack extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_running_app_track);
		new  HttpAsyncTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.running_app_track, menu);
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
	
	 class HttpAsyncTask extends AsyncTask<String, Void, String>
	{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			try
			{
			    Process mLogcatProc = null;
			    BufferedReader reader = null;
			    mLogcatProc = Runtime.getRuntime().exec(new String[]{"logcat", "-s"});

			    reader = new BufferedReader(new InputStreamReader(mLogcatProc.getInputStream()));

			    String line;
			    final StringBuilder log = new StringBuilder();
			    String separator = System.getProperty("line.separator"); 

			    while ((line = reader.readLine()) != null)
			    {
			        log.append(line);
			        log.append(separator);
			    }
			    String w = log.toString();
//			    Toast.makeText(getApplicationContext(),w, Toast.LENGTH_LONG).show();
			    Log.d("Run ",w);
			}
			catch (Exception e) 
			{
//			    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
			}
			
			return null;
		}
		
	}
}
