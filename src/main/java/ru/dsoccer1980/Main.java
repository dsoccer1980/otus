package ru.dsoccer1980;

import com.opencsv.CSVReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dsoccer1980.service.TestService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        Reader reader = Files.newBufferedReader(Paths.get("./questions.csv"));
//        CSVReader csvReader = new CSVReader(reader);
//        List<String[]> records = csvReader.readAll();
//        String[] strings = records.stream().filter(r -> r[0].equals("1")).findFirst().get();
//        for (String[] record : records) {
//            System.out.println("Name : " + record[1]);
//        }



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
