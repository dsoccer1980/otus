package ru.dsoccer1980.service;

import java.util.Map;

public interface QuestionService {

    Map<Integer, String> readAllQuestions();
    Map<Integer, String> readAllAnswers();

}
