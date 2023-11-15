package com.example.pinakaappdev;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity{
	private FirebaseAuth mAuth;
	EditText un, pw;
	private String username, password;
	Button loginBtn, createBtn;
	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mAuth = FirebaseAuth.getInstance();
		loginBtn = findViewById(R.id.loginBtn);
		createBtn = findViewById(R.id.createaccBtn);

		un = findViewById(R.id.txtUser);
		pw = findViewById(R.id.txtPw);




		loginBtn.setOnClickListener(view ->{
			username = un.getText().toString();
			password = pw.getText().toString();

		if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
			Toast.makeText(MainActivity.this, "No empty fiels are allowed.", Toast.LENGTH_SHORT).show();
		}else{
			mAuth.signInWithEmailAndPassword(username, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
					Intent gtNextPage = new Intent(getApplicationContext(), nextpage.class);
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success");
                   	startActivity(gtNextPage);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
		}
		});

		createBtn.setOnClickListener(view ->{
			Intent gtCreatePage = new Intent(MainActivity.this, registerform.class);
			startActivity(gtCreatePage);
		});
	}

}