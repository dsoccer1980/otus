package ru.dsoccer1980.service;

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
        for (int i = 0; i < 5; i++) {
            ioService.write(questionService.findQuestionById(i));
            String userAnswer = userAnswerService.readAnswer(i);
            String rightAnswer = questionService.findAnswerById(i);
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
