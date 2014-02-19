package com.UG.fragments;

import com.UG.activities.MainActivity;
import com.UG.activities.StoreDetailActivity;
import com.UG.tarea1.R;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class CommentsFragment extends Fragment implements OnClickListener {
	View view;
	String comment = "";
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Button btnAdd = (Button)view.findViewById(R.id.addComment);
		//btnAdd.setOnClickListener(this);
		
		//SimpleAdapter adapter = new SimpleAdapter(this, emails, android.R.layout.simple_list_item_1, comment, android.R.id.text1);
		//setListAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_comments, container, false);
		ImageView imageView = (ImageView)view.findViewById(R.id.commentImageView);
		imageView.setImageResource(R.drawable.comment);
		return view;
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		EditText commentTxt = (EditText)view.findViewById(R.id.newComment);
		comment = commentTxt.getText().toString();
		
	}
	
}
