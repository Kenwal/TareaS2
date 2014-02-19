package com.UG.data;

import com.UG.tarea1.R;
import com.UG.fragments.PromoFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PromoPagerAdapter extends FragmentPagerAdapter {
	private int[] arrayPromos = new int[]{
			R.drawable.eskala,
			R.drawable.promo1,
			R.drawable.promo2,
			R.drawable.promo3,
			R.drawable.promo4,
			R.drawable.promo5
	};
	
	public PromoPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new PromoFragment();
		Bundle args = new Bundle();
		args.putInt(PromoFragment.RESOURCE, arrayPromos[position]);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return arrayPromos.length;
	}
	
}
