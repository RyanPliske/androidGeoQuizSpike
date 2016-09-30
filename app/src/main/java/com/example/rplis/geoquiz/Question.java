package com.example.rplis.geoquiz;

public class Question {

    private int id;
    private boolean isTrue;

    public Question(int id, boolean answerIsTrue) {
        this.id = id;
        this.isTrue = answerIsTrue;
    }

    public int getQuestionId() {
        return id;
    }

    public boolean isTrue() {
        return isTrue;
    }

}
