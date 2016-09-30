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
        nextButton = (Button) findViewById(R.id.next_button);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        questionTextView = (TextView) findViewById(R.id.question_text_view);
        this.displayNextQuestion();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentQuestion", this.model.currentQuestionIndex);
        super.onSaveInstanceState(outState);
    }

    // Methods called from xml

    public void nextButtonClicked(View v) {
        this.model.nextQuestionRequested();
    }

    public void trueButtonClicked(View v) {
        Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
    }

    public void falseButtonClicked(View v) {
        Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
    }

    // QuestionListener methods

    public void displayNextQuestion() {
        questionTextView.setText(this.model.getCurrentQuestionId());
    }

}