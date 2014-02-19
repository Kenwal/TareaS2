package com.UG.fragments;

import com.UG.tarea1.R;
import com.UG.data.PromoPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StoresPromoFragment extends Fragment {
	ViewPager viewPager;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		PromoPagerAdapter adapter = new PromoPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_stores_promo, container, false);
		viewPager = (ViewPager)view.findViewById(R.id.pager);
		return view;
	}
	
}
