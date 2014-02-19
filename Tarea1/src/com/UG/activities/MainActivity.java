package com.UG.activities;

import com.UG.tarea1.R;
import com.UG.fragments.ComunityFragment;
import com.UG.fragments.StoresContentFragment;
import com.UG.fragments.StoresPromoFragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	private ListView drawerList;
	private String[] drawerOptions;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerToggle;
	private Fragment[] fragments = new Fragment[] { new StoresPromoFragment(),
			new StoresContentFragment(), new ComunityFragment() };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		drawerList = (ListView) findViewById(R.id.leftDrawer);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerOptions = getResources().getStringArray(R.array.drawer_options);

		drawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, drawerOptions));
		drawerList.setItemChecked(0, true);
		drawerList.setOnItemClickListener(new DrawerItemClickListener());

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.drawer, R.string.drawer_open, R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}

			public void onDrawerOpened(View drawerView) {
				ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			}
		};

		drawerLayout.setDrawerListener(drawerToggle);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.contentFrame, fragments[0])
				.add(R.id.contentFrame, fragments[1]).hide(fragments[1])
				.add(R.id.contentFrame, fragments[2]).hide(fragments[2])
				.commit();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (drawerLayout.isDrawerOpen(drawerList)) {
				drawerLayout.closeDrawer(drawerList);
			} else {
				drawerLayout.openDrawer(drawerList);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setContent(int index) {
		Fragment toShow = null;
		Fragment toHide = null;
		Fragment toHide2 = null;
		ActionBar actionBar = getSupportActionBar();
		switch (index) {
		case 0:
			toShow = fragments[0];
			toHide = fragments[1];
			toHide2 = fragments[2];
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			break;
		case 1:
			toHide = fragments[0];
			toShow = fragments[1];
			toHide2 = fragments[2];
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			break;
		case 2:
			toHide = fragments[0];
			toHide2 = fragments[1];
			toShow = fragments[2];
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
			break;
		}
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().hide(toHide).hide(toHide2).show(toShow).commit();
		drawerList.setItemChecked(index, true);
		drawerLayout.closeDrawer(drawerList);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			setContent(position);
		}
	}
	
}
