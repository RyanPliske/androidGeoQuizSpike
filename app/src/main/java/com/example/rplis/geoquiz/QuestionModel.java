package com.example.rplis.geoquiz;

public class QuestionModel {

    interface QuestionListener {
        void displayNextQuestion();
    }

    public QuestionListener listener;
    private int currentQuestionIndex;
    private Question[] questionBank;


    public QuestionModel(QuestionListener listener, int currentQuestionIndex) {
        this.questionBank = this.generateQuestionBank();
        this.listener = listener;
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public boolean getCurrentQuestionAnswer() {
        return this.questionBank[currentQuestionIndex].isTrue();
    }

    public int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }

    public int getCurrentQuestionId() {
        return this.questionBank[currentQuestionIndex].getQuestionId();
    }

    public void nextQuestionRequested() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
        if (listener != null) {
            listener.displayNextQuestion();
        }
    }

    private Question[] generateQuestionBank() {
        return new Question[]{
                new Question(R.string.question_africa, false),
                new Question(R.string.question_asia, true),
                new Question(R.string.question_oceans, true)
        };
    }

}
