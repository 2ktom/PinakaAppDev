package com.example.pinakaappdev;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.pinakaappdev.EasyQuestions.answers;
import static com.example.pinakaappdev.EasyQuestions.choices;
import static com.example.pinakaappdev.EasyQuestions.question;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class easy_gameplay extends AppCompatActivity{

	private TextView TextViewTimer;
    private Button option1, option2, option3, option4;
    private String answer;
    private int scoring = 0;
    private int numOfQuestions = 1;
    private int currentQuestionIndex;
    private CountDownTimer timerCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_gameplay);

        TextViewTimer = findViewById(R.id.TimeNumber);
        //TextViewScoring = findViewById(R.id.QuestionNumber);
        //TextViewQuestions = findViewById(R.id.WordToGuess);
        option1 = findViewById(R.id.FirstBtn);
        option2 = findViewById(R.id.SecondBtn);
        option3 = findViewById(R.id.ThirdBtn);
        option4 = findViewById(R.id.FourthBtn);

        timerCountDown = new CountDownTimer(15030, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextViewTimer.setText(String.valueOf(millisUntilFinished / 1000));
            }
            @Override
            public void onFinish() {
                nextQuestion();
            }
        }.start();

        updateQuestion();
    }

    private void updateQuestion() {
        Log.d("QuestionDebug", "Current Question Index: " + currentQuestionIndex);

        TextView TextViewQuestions = findViewById(R.id.QuestionNumber);
        TextViewQuestions.setText("" + (currentQuestionIndex + 1));

        TextView TextViewWordGuess = findViewById(R.id.WordToGuess);
        TextViewWordGuess.setText(question[currentQuestionIndex]);

        TextView TextViewScoring = findViewById(R.id.ScoreNumber);
        TextViewScoring.setText("" + scoring);

        option1.setText(choices[currentQuestionIndex][0]);
        option2.setText(choices[currentQuestionIndex][1]);
        option3.setText(choices[currentQuestionIndex][2]);
        option4.setText(choices[currentQuestionIndex][3]);

        answer = answers[currentQuestionIndex];

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(option1);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(option2);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(option3);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnswerSelected(option4);
            }
        });
    }


    // Method that checks the selected answer and navigates to the next screen
    public void onAnswerSelected(View view) {
        Button answerButton = (Button) view;
        if (answerButton.getText().toString().equals(answer)) {
            scoring += 1;
        }
        nextQuestion();
    }
    private void nextQuestion() {
        if (currentQuestionIndex < question.length - 1) {
            currentQuestionIndex++;
            updateQuestion();

            // Cancel the current timer
            if (timerCountDown != null) {
                timerCountDown.cancel();
            }

            // Start a new timer for the next question
            timerCountDown = new CountDownTimer(15030, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    TextViewTimer.setText(String.valueOf(millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    nextQuestion();
                }
            }.start();

            Log.d("AnswerDebug", "" + scoring);
        } else {
            // Go to the final screen to show the final score
            Intent intent = new Intent(this, FinalPage.class);
            intent.putExtra("SCORE", scoring);
            startActivity(intent);
            finish();
        }
    }
}