package ru.dsoccer1980.dao;

import java.util.Map;

public interface QuestionDao {

    Map<Integer, String> readAllQuestions();
    Map<Integer, String> readAllAnswers();
}
