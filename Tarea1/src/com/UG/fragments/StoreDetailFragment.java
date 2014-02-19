package com.UG.fragments;

import com.UG.tarea1.R;
import com.UG.activities.StoreDetailActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StoreDetailFragment extends Fragment implements OnClickListener {
	View view;
	String store = "";
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Activity activity = getActivity();
		if(activity instanceof StoreDetailActivity){
			store = ((StoreDetailActivity)getActivity()).getStore();
		}
		
		String[] detalles = null;
		
		if(store != null){
			
			TextView txtName = (TextView) view.findViewById(R.id.nombre);
			txtName.setText(store);
			
			TextView txtDir = (TextView) view.findViewById(R.id.direccion);
			txtDir.setText(R.string.direccion);
			Linkify.addLinks(txtDir, Linkify.MAP_ADDRESSES);
			
			TextView txtHorario = (TextView) view.findViewById(R.id.horarios);
			txtHorario.setText(R.string.horario);
			
			if(store.equals("Tienda Anais")) {
				detalles = getResources().getStringArray(R.array.anais_details);
			} else if(store.equals("Tienda Max")) {
				detalles = getResources().getStringArray(R.array.max_details);
			} else if(store.equals("Tienda Claro")) {
				detalles = getResources().getStringArray(R.array.claro_details);
			} else if(store.equals("Tienda Soccermania")) {
				detalles = getResources().getStringArray(R.array.soccermania_details);
			} else if(store.equals("McDonalds")) {
				detalles = getResources().getStringArray(R.array.mc_details);
			} else if(store.equals("Pizza Hut")) {
				detalles = getResources().getStringArray(R.array.piza_hut_details);
			}
			
			if(detalles != null){
				
				TextView txtTel = (TextView) view.findViewById(R.id.telefono);
				txtTel.setText(detalles[0].toString());
				Linkify.addLinks(txtTel, Linkify.PHONE_NUMBERS);

				TextView txtWeb = (TextView) view.findViewById(R.id.website);
				txtWeb.setText(detalles[1].toString());
				Linkify.addLinks(txtWeb, Linkify.WEB_URLS);
				
				TextView txtEmail = (TextView) view.findViewById(R.id.email);
				txtEmail.setText(detalles[2].toString());
				Linkify.addLinks(txtEmail, Linkify.EMAIL_ADDRESSES);
			}
		}
		
		Button btnCall = (Button)view.findViewById(R.id.btnCall);
		btnCall.setBackgroundResource(R.drawable.llamar);
		btnCall.setText("");
		/*btnCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		FragmentManager manager = getActivity().getSupportFragmentManager();
		manager.beginTransaction().add(R.id.commentsFrame, new CommentsFragment()).commit();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_store_detail, container, false);
		return view;
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		
		
	}
	
}
