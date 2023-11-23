package com.example.pinakaappdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Set;

public class SetAlias extends AppCompatActivity{

	Button confirmName;
	EditText aliasName;
	String firebaseUrl = "https://appdev-69e51-default-rtdb.asia-southeast1.firebasedatabase.app/";

	//private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appdev-69e51-default-rtdb.asia-southeast1.firebasedatabase.app/");

	String playerName = "";

	FirebaseDatabase firebaseDatabase;
	DatabaseReference playerRef;
	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_alias);

		confirmName = findViewById(R.id.btnCofirm);
		aliasName = findViewById(R.id.userAlias);

		firebaseDatabase = FirebaseDatabase.getInstance();



		SharedPreferences preferences = getSharedPreferences("myPreferences", 0);

		playerName = preferences.getString("playerName", "");

		if(!playerName.equals("")){
			playerRef = firebaseDatabase.getReference("players/" +playerName);
			addEventListner();
			playerRef.setValue("");
		}

		confirmName.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				// log the player in
				playerName = aliasName.getText().toString();
				aliasName.setText("");
				if(!playerName.equals("")){
					confirmName.setText("LOGGING IN");
					confirmName.setEnabled(false);
					playerRef = firebaseDatabase.getReference("players/" + playerName);
					addEventListner();
					playerRef.setValue("");
				}
			}
		});
	}
	private void addEventListner(){
		//read from database
		playerRef.addValueEventListener(new ValueEventListener(){
			@Override
			public void onDataChange(
					@NonNull DataSnapshot snapshot){
				if(!playerName.equals("")){


					SharedPreferences preferences = getSharedPreferences("myPreferences", 0);
					SharedPreferences.Editor editor = preferences.edit();
					editor.putString("playerName", playerName);
					editor.apply();

					startActivity(new Intent(getApplicationContext(), GameLobby.class));
					finish();
				}
			}

			@Override
			public void onCancelled(
					@NonNull DatabaseError error){
				//error
				confirmName.setText("Log in");
				confirmName.setEnabled(false);
				Toast.makeText(SetAlias.this, "Error!", Toast.LENGTH_SHORT).show();
			}
		});
	}
}