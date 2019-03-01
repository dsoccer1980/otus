package ru.dsoccer1980.service;

import org.springframework.stereotype.Service;
import ru.dsoccer1980.model.Question;

import java.util.List;

@Service
public class TestingServiceImpl implements TestingService {

    private final QuestionService questionService;
    private final IOService ioService;
    private int rightAnswersCount = 0;

    public TestingServiceImpl(QuestionService questionService, IOService ioService) {
        this.questionService = questionService;
        this.ioService = ioService;
    }

    @Override
    public void showQuestions() {
        List<Question> questions = questionService.getAllQuestions();

        for (Question question : questions) {
            ioService.write(question.getQuestion());
            ioService.write("Your answer: ");
            String userAnswer = ioService.read();
            String rightAnswer = question.getAnswer();
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
