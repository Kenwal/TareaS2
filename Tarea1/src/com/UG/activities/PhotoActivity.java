package com.UG.activities;

import com.UG.fragments.StorePhotoFragment;
import com.UG.tarea1.R;
import com.UG.tarea1.R.layout;
import com.UG.tarea1.R.menu;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

public class PhotoActivity extends FragmentActivity {
	private String store = "";
	public static final String STORE = "store";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photo);
		
		Intent intent = getIntent();
		store = intent.getStringExtra(STORE);
		
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction().add(R.id.photoFrame, new StorePhotoFragment()).commit();
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
		
		// cambiar para hacer share de la imagen
		
		Uri uri = null;
		
		switch(item.getItemId()){
			case R.id.action_share:
				if(!store.equals("")){
					if(store.equals("Tienda Anais")) {
						// uri = ;
					} else if(store.equals("Tienda Max")) {
						
					} else if(store.equals("Tienda Claro")) {
						
					} else if(store.equals("Tienda Soccermania")) {
						
					} else if(store.equals("McDonalds")) {
						
					} else if(store.equals("Pizza Hut")) {
						
					}
					
					String msg = getString(R.string.msg_share, storeName, url);
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_STREAM, uri);
					intent.setType("image/jpeg");
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
