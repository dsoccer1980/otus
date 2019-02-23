package ru.dsoccer1980.service;

import ru.dsoccer1980.dao.QuestionDao;

import java.util.Map;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Map<Integer, String> readAllQuestions() {
        return questionDao.readAllQuestions();
    }

    @Override
    public Map<Integer, String> readAllAnswers() {
        return questionDao.readAllAnswers();
    }

}
