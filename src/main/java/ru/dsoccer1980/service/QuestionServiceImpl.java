package ru.dsoccer1980.service;

import ru.dsoccer1980.dao.QuestionDao;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public String findQuestionById(int id) {
        return questionDao.findQuestionById(id);
    }

    @Override
    public String findAnswerById(int id) {
        return questionDao.findAnswerById(id);
    }
}
