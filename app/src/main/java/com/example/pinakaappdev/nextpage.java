package com.example.pinakaappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nextpage extends AppCompatActivity{

	Button single, mplayer;

	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nextpage);

		single = findViewById(R.id.SPbtn);
		mplayer = findViewById(R.id.MPbtn);

		single.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(
					View v){
				Intent goToGameType = new Intent(nextpage.this, gameplay.class);
				startActivity(goToGameType);
			}
		});

		mplayer.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(
					View v){
				Intent intent = new Intent(nextpage.this, SetAlias.class);
				startActivity(intent);
			}
		});
	}
}