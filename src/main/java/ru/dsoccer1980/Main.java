package ru.dsoccer1980;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dsoccer1980.service.TestService;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write your name");
        String name = bufferedReader.readLine();

        TestService testService = context.getBean(TestService.class);
        testService.showQuestions();

        System.out.println("Result of " + name + ": " + testService.getResult() + " right answers");

        bufferedReader.close();
        context.close();
    }
}
