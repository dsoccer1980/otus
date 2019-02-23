package ru.dsoccer1980.service;

import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TestServiceImplTest {

    @Test
    void testAllAnswersRight() {
        QuestionService questionService = mock(QuestionService.class);
        IOService ioService = mock(IOService.class);
        UserAnswerService userAnswerService = mock(UserAnswerService.class);

        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Q1");
        questions.put(2, "Q2");
        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "answer1");
        answers.put(2, "answer2");

        when(questionService.readAllQuestions()).thenReturn(questions);
        when(questionService.readAllAnswers()).thenReturn(answers);
        when(userAnswerService.readAnswer(1)).thenReturn("answer1");
        when(userAnswerService.readAnswer(2)).thenReturn("answer2");

        TestService testService = new TestServiceImpl(questionService, userAnswerService, ioService);
        testService.showQuestions();
        assertEquals(2, testService.getResult());
    }

    @Test
    void testOneAnswerWrong() {
        QuestionService questionService = mock(QuestionService.class);
        IOService ioService = mock(IOService.class);
        UserAnswerService userAnswerService = mock(UserAnswerService.class);

        Map<Integer, String> questions = new HashMap<>();
        questions.put(1, "Q1");
        questions.put(2, "Q2");
        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "answer1");
        answers.put(2, "answer2");

        when(questionService.readAllQuestions()).thenReturn(questions);
        when(questionService.readAllAnswers()).thenReturn(answers);
        when(userAnswerService.readAnswer(1)).thenReturn("answer1");
        when(userAnswerService.readAnswer(2)).thenReturn("wrong");

        TestService testService = new TestServiceImpl(questionService, userAnswerService, ioService);
        testService.showQuestions();
        assertEquals(1, testService.getResult());
    }
}