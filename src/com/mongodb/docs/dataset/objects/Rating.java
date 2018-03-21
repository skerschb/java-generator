package com.mongodb.docs.dataset.objects;

public class Rating {

    private String letter;
    private int score;

    public void setLetter(final String grade) {
        this.letter = grade;
    }

    public String getLetter() {
        return this.letter;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

}
