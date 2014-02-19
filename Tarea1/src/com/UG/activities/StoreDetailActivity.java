package com.UG.activities;

import com.UG.tarea1.R;
import com.UG.fragments.StoreDetailFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

public class StoreDetailActivity extends FragmentActivity {
	private String store = "";
	public static final String STORE = "store";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_detail);
		
        Intent intent = getIntent();
		store = intent.getStringExtra(STORE);
		
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.detailFrame, new StoreDetailFragment()).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String storeName = "";
		String url = "";
		switch(item.getItemId()){
			case R.id.action_share:
				if(!store.equals("")){
					if(store.equals("Tienda Anais")) {
						storeName = "la " + store;
						url = getResources().getStringArray(R.array.anais_details)[1];
					} else if(store.equals("Tienda Max")) {
						storeName = "la " + store;
						url = getResources().getStringArray(R.array.max_details)[1];
					} else if(store.equals("Tienda Claro")) {
						storeName = "la " + store;
						url = getResources().getStringArray(R.array.claro_details)[1];
					} else if(store.equals("Tienda Soccermania")) {
						storeName = "la " + store;
						url = getResources().getStringArray(R.array.soccermania_details)[1];
					} else if(store.equals("McDonalds")) {
						storeName = store;
						url = getResources().getStringArray(R.array.mc_details)[1];
					} else if(store.equals("Pizza Hut")) {
						storeName = store;
						url = getResources().getStringArray(R.array.piza_hut_details)[1];
					}
					String msg = getString(R.string.msg_share, storeName, url);
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_TEXT, msg);
					intent.setType("text/plain");
					startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
				}
				return true;
			default: 
				return super.onOptionsItemSelected(item);
		}
	}
	
	public String getStore() {
		return store;
	}

}
