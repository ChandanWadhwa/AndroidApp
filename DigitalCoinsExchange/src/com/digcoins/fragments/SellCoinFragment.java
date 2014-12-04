package com.digcoins.fragments;

import com.digcoins.digitalcoinsexchange.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class SellCoinFragment extends Fragment {
	
	public SellCoinFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home_fragment, container, false);
         
        return rootView;
    }
}
