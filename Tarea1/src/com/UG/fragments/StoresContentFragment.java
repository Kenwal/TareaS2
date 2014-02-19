package com.UG.fragments;

import com.UG.tarea1.R;
import com.UG.activities.MainActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StoresContentFragment extends Fragment implements TabListener{
	Fragment[] fragments = new Fragment[]{ new StoresListFragment(), new StoresMapFragment() };
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
		actionBar.addTab(actionBar.newTab().setText(getString(R.string.title_fragment_list)).setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(getString(R.string.title_fragment_maps)).setTabListener(this));
        
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().add(R.id.storesContent, fragments[0]).add(R.id.storesContent, fragments[1]).commit();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_stores_content, container, false);
		return view;
	}
	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment toHide = null;
		Fragment toShow = null;
		switch(tab.getPosition()){
			case 0: 
				toShow = fragments[0];
				toHide = fragments[1];
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				break;
		}
		ft.hide(toHide).show(toShow);
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
	
}
