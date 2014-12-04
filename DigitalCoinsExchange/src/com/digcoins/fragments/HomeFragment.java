package com.digcoins.fragments;


import com.digcoins.digitalcoinsexchange.R;
import com.digicoins.tabadapter.TabsPagerAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class HomeFragment extends Fragment {
	
	FragmentTransaction fragmentTransaction;
	FragmentManager fragmentManager;
	BuyAdsFragment buyAdsFragment;
	SellAdsFragment sellAdsFragment;
	LocationFragment locationFragment;
	Button btnbuyads,btnsellads,btnlocation;	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home_fragment, container, false);
		
	
		fragmentManager = getFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		buyAdsFragment= new BuyAdsFragment();
		fragmentTransaction.replace(R.id.frag_layout, buyAdsFragment);
		fragmentTransaction.commit();
		btnbuyads=(Button)rootView.findViewById(R.id.btnbuyads);
		btnbuyads.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				btnbuyads.setTypeface(null,Typeface.BOLD);
				btnsellads.setTypeface(null,Typeface.NORMAL);
				btnlocation.setTypeface(null,Typeface.NORMAL);
				buyAds();
			}
		});
		btnsellads=(Button)rootView.findViewById(R.id.btnsellads);
		btnsellads.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			btnsellads.setTypeface(null,Typeface.BOLD);
			btnbuyads.setTypeface(null,Typeface.NORMAL);
			btnlocation.setTypeface(null,Typeface.NORMAL);
			sellAds();	
			}
		});
		btnlocation=(Button)rootView.findViewById(R.id.btnlocation);
		btnlocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btnlocation.setTypeface(null,Typeface.BOLD);
				btnbuyads.setTypeface(null,Typeface.NORMAL);
				btnsellads.setTypeface(null,Typeface.NORMAL);
				location();
			}
		});
		
		//Bold the Buy Ads Tabs
		btnbuyads.setTypeface(null,Typeface.BOLD);
		btnsellads.setTypeface(null,Typeface.NORMAL);
		btnlocation.setTypeface(null,Typeface.NORMAL);
		return rootView;
		
    }
	
	public void buyAds()
	{
		fragmentManager = getFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		buyAdsFragment= new BuyAdsFragment();
		fragmentTransaction.replace(R.id.frag_layout, buyAdsFragment);
		fragmentTransaction.commit();
	}
	
	public void location()
	{
		fragmentManager = getFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		locationFragment= new LocationFragment();
		fragmentTransaction.replace(R.id.frag_layout, locationFragment);
		fragmentTransaction.commit();
	}
	
	public void sellAds()
	{
		fragmentManager = getFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		sellAdsFragment= new SellAdsFragment();
		fragmentTransaction.replace(R.id.frag_layout, sellAdsFragment);
		fragmentTransaction.commit();
	}
//	class HomeFragmentActivity extends FragmentActivity implements TabListener
//	{
//		private ViewPager viewPager;
//		private TabsPagerAdapter mAdapter;
//		private ActionBar actionBar;
//		// Tab titles
//		private String[] tabs = { "BUY ADS", "SELL ADS", "LOCATION" };
//		@Override
//		protected void onCreate(Bundle savedInstanceState) {
//			super.onCreate(savedInstanceState);
//			setContentView(R.layout.fragment_buy_ads);
//			// Initilization
//			viewPager = (ViewPager) findViewById(R.id.pager);
//			actionBar = getActionBar();
//			mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
//	
//			viewPager.setAdapter(mAdapter);
//			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		
//	
//			// Adding Tabs
//			for (String tab_name : tabs) {
//					actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
//				}
//			
//		}
//		@Override
//		public void onTabReselected(Tab tab, FragmentTransaction ft) {
//		}
//
//		@Override
//		public void onTabSelected(Tab tab, FragmentTransaction ft) {
//			// on tab selected
//			// show respected fragment view
//			viewPager.setCurrentItem(tab.getPosition());
//		}
//
//		@Override
//		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
//		}
//	}
}
