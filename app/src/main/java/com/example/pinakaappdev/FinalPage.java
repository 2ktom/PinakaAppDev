package com.example.pinakaappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class FinalPage extends AppCompatActivity{


	 public Button ctnBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_page);
		ctnBtn = findViewById(R.id.btnCtn);

		// Find the TextView to display the score
		TextView scoreTextView = findViewById(R.id.ScoreResult);



		// Get the score from the intent
		Intent intent = getIntent();
		if(intent != null && intent.hasExtra("SCORE")){
			int score = intent.getIntExtra("SCORE", 0);

			// Display the score in the TextView
			scoreTextView.setText("" + score);
		}
		ctnBtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(
					View v){
			Intent goToDashboard = new Intent(FinalPage.this, nextpage.class);
			startActivity(goToDashboard);
			}
		});
	}

}