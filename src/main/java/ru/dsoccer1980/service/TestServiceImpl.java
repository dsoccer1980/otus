package ru.dsoccer1980.service;

public class TestServiceImpl implements TestService {

    private final QuestionService questionService;
    private final IOService ioService;
    private int rightAnswer = 0;

    public TestServiceImpl(QuestionService questionService, IOService ioService) {
        this.questionService = questionService;
        this.ioService = ioService;
    }


    @Override
    public void showQuestions() {
        for (int i = 0; i < 5; i++) {
            ioService.write(questionService.findQuestionById(i));
            String userAnswer = ioService.read();
            if (isRightAnswer(i, userAnswer)) {
                rightAnswer++;
            }
        }
    }

    @Override
    public int getResult() {
        return rightAnswer;
    }

    private boolean isRightAnswer(int id, String answer) {
        return questionService.findAnswerById(id).equals(answer);
    }


}
