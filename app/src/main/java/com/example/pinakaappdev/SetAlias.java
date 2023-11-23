package com.example.pinakaappdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
	private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appdev-69e51-default-rtdb.asia-southeast1.firebasedatabase.app/");
	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set_alias);

		confirmName = findViewById(R.id.btnCofirm);
		aliasName = findViewById(R.id.userAlias);

		confirmName.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v){

				final String userAlias = aliasName.getText().toString();
				if(userAlias.isEmpty()){
					Toast.makeText(SetAlias.this, "Player alias is empty or invalid. Please try again!", Toast.LENGTH_SHORT).show();
				}
				else {
					Intent intent = new Intent(SetAlias.this, GameLobby.class);
					intent.putExtra("playername", userAlias);
					startActivity(intent);
					finish();
				}
			}
		});
	}
}