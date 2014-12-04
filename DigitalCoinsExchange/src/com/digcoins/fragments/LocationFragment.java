package com.digcoins.fragments;

import com.digcoins.digitalcoinsexchange.R;
import com.digcoins.digitalcoinsexchange.R.layout;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class LocationFragment extends Fragment {

//	public LocationFragment() {
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_location,
				container, false);
		return rootView;
	}
}
