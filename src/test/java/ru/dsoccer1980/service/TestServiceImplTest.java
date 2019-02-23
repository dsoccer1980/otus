package ru.dsoccer1980.service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TestServiceImplTest {

    @Test
    void showQuestions() {
        QuestionService questionService = mock(QuestionService.class);
        IOService ioService = mock(IOService.class);
        UserAnswerService userAnswerService = mock(UserAnswerService.class);
        for (int i = 0; i < 5; i++) {
            when(questionService.findQuestionById(i)).thenReturn(i+ "");
            when(questionService.findAnswerById(i)).thenReturn(i + "");
            when(userAnswerService.readAnswer(i)).thenReturn(i + "");

        }

       TestService testService =new TestServiceImpl(questionService, userAnswerService, ioService);
       testService.showQuestions();
       assertEquals(5, testService.getResult());

    }
}