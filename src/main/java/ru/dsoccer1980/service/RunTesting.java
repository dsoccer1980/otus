package ru.dsoccer1980.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class RunTesting {

    private TestingService testingService;
    private IOService ioService;

    public RunTesting(TestingService testingService, IOService ioService) {
        this.testingService = testingService;
        this.ioService = ioService;
    }

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ioService.write("Write your name");
        String name = bufferedReader.readLine();

        testingService.showQuestions();

        ioService.write("Result of " + name + ": " + testingService.getResult() + " right answers");
    }
}
