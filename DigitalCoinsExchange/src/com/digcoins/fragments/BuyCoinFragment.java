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

public class BuyCoinFragment extends Fragment {
	
	public BuyCoinFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_buy_coin_fragment, container, false);
         
        return rootView;
    }
}
