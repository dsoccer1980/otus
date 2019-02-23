package ru.dsoccer1980.model;

import java.util.HashMap;
import java.util.Map;

public class QuestionDatabase {

    public Map<Integer, String> questions = new HashMap<>();
    public Map<Integer, String> answers = new HashMap<>();

    public QuestionDatabase() {
        questions.put(0, "Q1");
        questions.put(1, "Q2");
        questions.put(2, "Q3");
        questions.put(3, "Q4");
        questions.put(4, "Q5");

        answers.put(0, "A1");
        answers.put(1, "A2");
        answers.put(2, "A3");
        answers.put(3, "A4");
        answers.put(4, "A5");
    }
}
