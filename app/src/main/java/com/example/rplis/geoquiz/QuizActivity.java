package com.example.rplis.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class QuizActivity extends AppCompatActivity implements QuestionModel.QuestionListener {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private QuestionModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        if (savedInstanceState != null) {
            this.model = new QuestionModel(this, savedInstanceState.getInt("currentQuestion"));
        } else {
            this.model = new QuestionModel(this, 0);
        }

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });
        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });
        questionTextView = (TextView) findViewById(R.id.question_text_view);
        this.displayNextQuestion();

        nextButton = (Button) findViewById(R.id.next_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentQuestion", this.model.currentQuestionIndex);
        super.onSaveInstanceState(outState);
    }

    public void nextButtonClicked(View v) {
        this.model.nextQuestionRequested();
    }

    public void displayNextQuestion() {
        questionTextView.setText(this.model.getCurrentQuestionId());
    }

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_africa, false),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_oceans, true)
    };

}