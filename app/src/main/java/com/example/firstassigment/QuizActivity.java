package com.example.firstassigment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {

    int counter;
    private RadioButton r , r2 , r3 , r4 ,r5;
    private Button btnFinish ;
    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        hookking();
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                if(r.isChecked()){
                    counter++;
                }
                if(r2.isChecked()){
                    counter++;
                }
                if(r3.isChecked()){
                    counter++;
                }
                if(r4.isChecked()){
                    counter++;
                }
                if(r5.isChecked()){
                    counter++;
                }
                res.setText(String.valueOf(counter + "/5"));
                res.setVisibility(View.VISIBLE);
                if(counter > 2)
                    res.setTextColor(Color.GREEN);
                else
                    res.setTextColor(Color.RED);
            }
        });

    }
    public void hookking(){
        r = findViewById(R.id.C);
        r2 = findViewById(R.id.C2);
        r3 = findViewById(R.id.C3);
        r4 = findViewById(R.id.C4);
        r5 = findViewById(R.id.C5);
        btnFinish = findViewById(R.id.btnFinish);
        res = findViewById(R.id.txtRes);
    }
}