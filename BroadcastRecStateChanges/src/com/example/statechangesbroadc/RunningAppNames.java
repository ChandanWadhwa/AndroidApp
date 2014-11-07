package com.example.statechangesbroadc;

import java.util.*;

import android.support.v7.app.ActionBarActivity;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RunningAppNames extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_running_app_names);
//		ActivityManager am = (ActivityManager)this.getSystemService(ACTIVITY_SERVICE);
//		List l = am.getRunningAppProcesses();
//		Iterator i = l.iterator();
//		PackageManager pm = this.getPackageManager();
//		while(i.hasNext()) {
//		  ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo)(i.next());
//		  try {
//		    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
//		    Log.w("LABEL", c.toString());
//		  }catch(Exception e) {
//		    //Name Not FOund Exception
//		  }
//		}
		
//		ActivityManager result = (ActivityManager)getApplicationContext().getSystemService(getApplicationContext().ACTIVITY_SERVICE);
//		ArrayList<RecentTaskInfo> apps = (ArrayList<RecentTaskInfo>) result.getRecentTasks(10, ActivityManager.RECENT_WITH_EXCLUDED);
		
		
		ActivityManager actvityManager = (ActivityManager)
				
				this.getSystemService( ACTIVITY_SERVICE );
				
				List<RunningAppProcessInfo> procInfos = actvityManager.getRunningAppProcesses();
				boolean appFound = false;
				for(int i = 0; i < procInfos.size(); i++)
				{
				   Log.d("Running process ",procInfos.get(i).processName);
		
				       
				
				}
		
//		TextView tv = new TextView(this);
//		this.setContentView(tv);
//		ActivityManager actvityManager = (ActivityManager)this.getSystemService( ACTIVITY_SERVICE );
//		List<RecentTaskInfo> procInfos = actvityManager.getRecentTasks( 20, ActivityManager.RECENT_IGNORE_UNAVAILABLE);
//		for(int i = 0; i < procInfos.size(); i++)
//		{
//			ComponentName comName=procInfos.get(i).origActivity;
//	        String  packageName = comName.getPackageName();
//			tv.setText(tv.getText().toString()+packageName+" " +"\n");
//			Log.d("Running process ",packageName+"");
//			
//
//		}



		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.running_app_names, menu);
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
