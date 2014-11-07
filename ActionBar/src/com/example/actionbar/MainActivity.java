package com.example.actionbar;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity{

	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_main);

		ActionBar actionBar=getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);
		
		
		Tab tabOne = actionBar.newTab();
		
		tabOne.setText("First Tab");
		tabOne.setIcon(R.drawable.ic_launcher);
		tabOne.setContentDescription("Tab the First");
		tabOne.setTabListener(new TabListener<Fragment1>(this, "First Tab",Fragment1.class));
		actionBar.addTab(tabOne);
		
		
		Tab tabTwo = actionBar.newTab();
		
		tabTwo.setText("Second Tab");
		tabTwo.setIcon(R.drawable.ic_launcher);
		tabTwo.setContentDescription("Tab the Second");
		tabTwo.setTabListener(new TabListener<Fragment2>(this, "Second Tab",Fragment2.class));
		actionBar.addTab(tabTwo);
	}
	

	public static class TabListener<T extends Fragment> 
    implements ActionBar.TabListener{
    
       private final Activity myActivity;
       private final String myTag;
       private final Class<T> myClass;

       public TabListener(Activity activity, String tag, Class<T> cls) {
           myActivity = activity;
           myTag = tag;
           myClass = cls;
       }

 @Override
 public void onTabSelected(Tab tab, FragmentTransaction ft) {

  Fragment myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);
  
  // Check if the fragment is already initialized
        if (myFragment == null) {
            // If not, instantiate and add it to the activity
            myFragment = Fragment.instantiate(myActivity, myClass.getName());
            ft.add(android.R.id.content, myFragment, myTag);
        } else {
            // If it exists, simply attach it in order to show it
            ft.attach(myFragment);
        }
  
 }

 @Override
 public void onTabUnselected(Tab tab, FragmentTransaction ft) {
  
  Fragment myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);
  
  if (myFragment != null) {
            // Detach the fragment, because another one is being attached
            ft.detach(myFragment);
        }
  
 }

 @Override
 public void onTabReselected(Tab tab, FragmentTransaction ft) {
  // TODO Auto-generated method stub
  
 }
    
   }

	
	
	public void NextActivity(View v)
	{
		Intent i=new Intent(getApplicationContext(),NextActivity.class);
		startActivity(i);
	}
}
