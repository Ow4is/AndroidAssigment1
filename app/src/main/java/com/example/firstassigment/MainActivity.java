package com.example.firstassigment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnLearn;
    private Button btnPractice;
    private Button btnQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        hookking();
        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent learnIntent = new Intent(MainActivity.this , LearningActivity.class);
                startActivity(learnIntent);
            }
        });

        btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent practiceIntent = new Intent(MainActivity.this , PracticeActivity.class);
                startActivity(practiceIntent);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent practiceIntent = new Intent(MainActivity.this , QuizActivity.class);
                startActivity(practiceIntent);
            }
        });
    }
    public void hookking(){
        btnLearn = findViewById(R.id.learnBtn);
        btnPractice = findViewById(R.id.practBtn);
        btnQuiz = findViewById(R.id.quizBtn);
    }
}