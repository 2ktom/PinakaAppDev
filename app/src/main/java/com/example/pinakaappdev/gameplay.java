package com.example.pinakaappdev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameplay extends AppCompatActivity{

	Button easyBtn, averageBtn, difficultBtn;

	@Override
	protected void onCreate(
			Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameplay);

		easyBtn = findViewById(R.id.EasyBtn);
        averageBtn = findViewById(R.id.AverageBtn);
        difficultBtn = findViewById(R.id.DifficultBtn);


        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameplay = new Intent(gameplay.this, easy_gameplay.class);
                startActivity(gameplay);
            }
        });

        averageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameplay = new Intent(gameplay.this, average_gameplay.class);
                startActivity(gameplay);
            }
        });

        difficultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameplay = new Intent(gameplay.this, difficult_gameplay.class);
                startActivity(gameplay);
            }
        });
	}
}