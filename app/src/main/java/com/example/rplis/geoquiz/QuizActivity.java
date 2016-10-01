package com.example.rplis.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class QuizActivity extends AppCompatActivity implements QuestionModel.QuestionListener {

    private static final String TAG = "QuizActivity";
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private QuestionModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() Called");
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
        super.onSaveInstanceState(outState);
        outState.putInt("currentQuestion", this.model.getCurrentQuestionIndex());
        Log.d(TAG, "onSaveInstanceState() Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResaume() Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() Called");
    }

    // Methods called from xml

    public void nextButtonClicked(View v) {
        this.model.nextQuestionRequested();
    }

    public void trueButtonClicked(View v) {
        checkAnswer(true);
    }

    public void falseButtonClicked(View v) {
        checkAnswer(false);
    }

    private void checkAnswer(boolean usersAnswer) {
        int messageResId = R.string.incorrect_toast;
        if (usersAnswer == this.model.getCurrentQuestionAnswer()) {
            messageResId = R.string.correct_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    // QuestionListener methods

    public void displayNextQuestion() {
        questionTextView.setText(this.model.getCurrentQuestionId());
    }

}