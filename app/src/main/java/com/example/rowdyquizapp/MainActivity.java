package com.example.rowdyquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rowdyquizapp.module.QuizBank;

public class MainActivity extends AppCompatActivity {

    private QuizBank quizBank;

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

        Button true_btn, false_btn, next_btn;

        createQuizBank();
        displayQuestion();

        true_btn = findViewById(R.id.true_btn);
        false_btn = findViewById(R.id.false_btn);
        next_btn = findViewById(R.id.next_btn);


         
        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getAnswer()){
                    Toast.makeText(v.getContext(), "Right answer", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(v.getContext(), "Wrong answer. Try again!", Toast.LENGTH_LONG).show();
                }
            }
        });

        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!getAnswer()) {
                    Toast.makeText(v.getContext(), "Right answer", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(v.getContext(), "Wrong answer. Try Again!", Toast.LENGTH_LONG).show();
                }
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuestion();
            }
        });

    }

        public void createQuizBank(){
                quizBank = new QuizBank();
                quizBank.loadQuestion();
        }

        public void displayQuestion()
        {
            quizBank.getCurrentQuestion();
            TextView quiz_question;
            quiz_question = findViewById(R.id.question);
            quiz_question.setText(getQuestion());
        }

        private String getQuestion(){
            return quizBank.getCurrentQuestionText();
        }

        private boolean getAnswer() {
            return quizBank.getCurrentQuestionAnswer();
        }

}
