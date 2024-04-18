package com.example.firstassigment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticeActivity extends AppCompatActivity {

    private EditText txtSnAfter , txtSnBefore , txtHBefore , txtHAfter , txtOBefore , txtOAfter , answerASn
            , answerBH , answerAHO , answerBSn;
    private Button btnCheckNum , btnShowAnswers1 , btnCheckAnswer , btnShowAnswers2;
    private TextView lblResult;
    private LinearLayout hbox , hbox2;
    private TextView lblStep2 , lblResult2 , lblCong , goToQuiz;
    private boolean flag1 = false , flag2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        hookking();
        btnCheckNumHandle();
        btnShowAnswers1Handle();
        btnCheckAnswerHandle();
        btnShowAnswers2Handle();
        btnGoToQuizHandle();

    }

    public void btnGoToQuizHandle(){
        goToQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PracticeActivity.this , QuizActivity.class);
                startActivity(i);
            }
        });
    }

    public void btnShowAnswers2Handle(){
        btnShowAnswers2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2 == false) {
                    btnShowAnswers2.setText("Hide Answers");
                    flag2 = true;
                    answerAHO.setText("2");
                    answerBH.setText("2");
                    answerASn.setText("1");
                    answerBSn.setText("1");
                    return;
                }
                if(flag2 == true) {
                    btnShowAnswers2.setText("Show Answers");
                    flag2 = false;
                    answerAHO.setText("");
                    answerBH.setText("");
                    answerASn.setText("");
                    answerBSn.setText("");
                    return;
                }
            }
        });
    }
    public void btnCheckAnswerHandle(){
        btnCheckAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerASn.getText().toString().length() < 1 || answerBSn.getText().toString().length() < 1
                        || answerBH.getText().toString().length() < 1 || answerAHO.getText().toString().length() < 1) {
                    Toast.makeText(PracticeActivity.this,"Enter Data" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Integer.valueOf(answerASn.getText().toString()) == 1 && Integer.valueOf(answerBSn.getText().toString()) == 1
                        && Integer.valueOf(answerBH.getText().toString()) == 2 && Integer.valueOf(answerAHO.getText().toString()) == 2){
                    lblResult2.setVisibility(View.VISIBLE);
                    lblResult2.setText("Correct");
                    lblResult2.setTextColor(Color.GREEN);
                    btnCheckAnswer.setVisibility(View.GONE);
                    btnShowAnswers2.setVisibility(View.GONE);
                    lblCong.setVisibility(View.VISIBLE);
                    goToQuiz.setVisibility(View.VISIBLE);
                }else{
                    lblResult2.setVisibility(View.VISIBLE);
                    lblResult2.setText("False");
                    lblResult2.setTextColor(Color.RED);
                }
            }
        });

    }

    public void btnShowAnswers1Handle(){
        btnShowAnswers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1 == false) {
                    btnShowAnswers1.setText("Hide Answers");
                    flag1 = true;
                    txtSnBefore.setText("1");
                    txtSnAfter.setText("1");
                    txtOAfter.setText("1");
                    txtOBefore.setText("2");
                    txtHAfter.setText("2");
                    txtHBefore.setText("2");
                    return;
                }
                if(flag1 == true) {
                    btnShowAnswers1.setText("Show Answers");
                    flag1 = false;
                    txtSnBefore.setText("");
                    txtSnAfter.setText("");
                    txtOAfter.setText("");
                    txtOBefore.setText("");
                    txtHAfter.setText("");
                    txtHBefore.setText("");
                    return;
                }
            }
        });
    }
    public void btnCheckNumHandle(){
        btnCheckNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtSnAfter.getText().toString().length() < 1 || txtSnBefore.getText().toString().length() < 1
                        || txtHAfter.getText().toString().length() < 1 || txtHBefore.getText().toString().length() < 1
                        || txtOBefore.getText().toString().length() < 1 || txtOAfter.getText().toString().length() < 1  ) {
                    Toast.makeText(PracticeActivity.this,"Enter Data" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Integer.valueOf(txtSnAfter.getText().toString()) == 1 && Integer.valueOf(txtSnBefore.getText().toString()) == 1
                        && Integer.valueOf(txtHAfter.getText().toString()) == 2 && Integer.valueOf(txtHBefore.getText().toString()) == 2
                        && Integer.valueOf(txtOAfter.getText().toString()) == 1 && Integer.valueOf(txtOBefore.getText().toString()) == 2){
                    lblResult.setVisibility(View.VISIBLE);
                    lblResult.setText("Correct");
                    lblResult.setTextColor(Color.GREEN);
                    lblStep2.setVisibility(View.VISIBLE);
                    hbox.setVisibility(View.VISIBLE);
                    hbox2.setVisibility(View.VISIBLE);
                    btnShowAnswers2.setVisibility(View.VISIBLE);
                    btnCheckAnswer.setVisibility(View.VISIBLE);
                    btnCheckNum.setVisibility(View.INVISIBLE);
                    btnShowAnswers1.setVisibility(View.INVISIBLE);
                }else{
                    lblResult.setVisibility(View.VISIBLE);
                    lblResult.setText("False");
                    lblResult.setTextColor(Color.RED);
                }

            }
        });
    }
    public void hookking(){
        txtSnAfter = findViewById(R.id.txtAnswerPSn);
        txtSnBefore = findViewById(R.id.txtAnswerRSn);
        txtHBefore = findViewById(R.id.txtAnswerBH);
        txtHAfter = findViewById(R.id.txtAnswerAH);
        txtOBefore = findViewById(R.id.txtAnswerBO);
        txtOAfter = findViewById(R.id.txtAnswerAO);
        btnCheckNum = findViewById(R.id.btnAnswer);
        btnShowAnswers1 = findViewById(R.id.btnShowAnswers1);
        lblResult = findViewById(R.id.lblResult);
        hbox = findViewById(R.id.Hbox);
        hbox2 = findViewById(R.id.Hbox2);
        lblStep2 = findViewById(R.id.lblStep2);
        btnCheckAnswer = findViewById(R.id.btnAnswer2);
        btnShowAnswers2 = findViewById(R.id.btnShowAnswers);
        answerAHO = findViewById(R.id.txtAH);
        answerBH = findViewById(R.id.txtBH);
        answerBSn = findViewById(R.id.txtRSn);
        answerASn = findViewById(R.id.SnAfter);
        lblResult2 = findViewById(R.id.lblResult2);
        lblCong = findViewById(R.id.lblCong);
        goToQuiz = findViewById(R.id.btnGoToQuiz);
    }


}