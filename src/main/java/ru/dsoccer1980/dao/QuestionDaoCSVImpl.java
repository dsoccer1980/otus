package ru.dsoccer1980.dao;

import com.opencsv.CSVReader;
import ru.dsoccer1980.model.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoCSVImpl implements QuestionDao {
    private final static String FILENAME = "questions.csv";


    @Override
    public List<Question> getAllQuestions() {
        ClassLoader classLoader = getClass().getClassLoader();
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(classLoader.getResource(FILENAME).getFile()));
             CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                questions.add(new Question(Integer.valueOf(record[0]), record[1], record[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
