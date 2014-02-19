package com.UG.fragments;

import com.UG.tarea1.R;
import com.UG.activities.StoreDetailActivity;
import java.util.ArrayList;
import java.util.Arrays;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StoresListFragment extends Fragment implements OnItemClickListener{
	View view;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

        String[] listOptions = getResources().getStringArray(R.array.stores);
        ArrayList<String> stores = new ArrayList<String>(Arrays.asList(listOptions));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, stores);
        ListView list = (ListView)view.findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_stores_list, container, false);
		return view;
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
		String store = adapterView.getItemAtPosition(position).toString();
		Intent intent = new Intent(getActivity(), StoreDetailActivity.class);
		intent.putExtra(StoreDetailActivity.STORE, store);
		startActivity(intent);
	}
	
}
