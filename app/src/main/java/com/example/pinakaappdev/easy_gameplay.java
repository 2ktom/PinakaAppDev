package com.example.pinakaappdev;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.pinakaappdev.EasyQuestions.answers;
import static com.example.pinakaappdev.EasyQuestions.choices;
import static com.example.pinakaappdev.EasyQuestions.question;

import android.os.Bundle;

public class easy_gameplay extends AppCompatActivity{

	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_easy_gameplay);
	}
}