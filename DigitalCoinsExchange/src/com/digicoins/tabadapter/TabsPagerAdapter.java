package com.digicoins.tabadapter;


import com.digcoins.fragments.BuyAdsFragment;
import com.digcoins.fragments.LocationFragment;
import com.digcoins.fragments.SellAdsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

//		switch (index) {
//		case 0:
//			// Buy Ads fragment activity
//			return new BuyAdsFragment();
//		case 1:
//			// Sell Ads fragment activity
//			return new SellAdsFragment();
//		case 2:
//			// Location fragment activity
//			return new LocationFragment();
//		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
