package ru.dsoccer1980.service;

import java.util.Map;

public class TestServiceImpl implements TestService {

    private final QuestionService questionService;
    private final UserAnswerService userAnswerService;
    private final IOService ioService;
    private int rightAnswersCount = 0;

    public TestServiceImpl(QuestionService questionService, UserAnswerService userAnswerService, IOService ioService) {
        this.questionService = questionService;
        this.userAnswerService = userAnswerService;
        this.ioService = ioService;
    }

    @Override
    public void showQuestions() {
        Map<Integer, String> questions = questionService.readAllQuestions();
        Map<Integer, String> answers = questionService.readAllAnswers();

        for (Map.Entry<Integer, String> question : questions.entrySet()) {
            ioService.write(question.getValue());
            ioService.write("Your answer: ");
            String userAnswer = userAnswerService.readAnswer(question.getKey());
            String rightAnswer = answers.get(question.getKey());
            if (userAnswer.equals(rightAnswer)) {
                this.rightAnswersCount++;
            }
        }
    }

    @Override
    public int getResult() {
        return rightAnswersCount;
    }

}
