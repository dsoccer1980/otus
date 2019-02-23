package ru.dsoccer1980.dao;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDaoCSVImpl implements QuestionDao {
    private final String questionFilePath = "./questions.csv";
    private final String answerFilePath = "./answers.csv";

    @Override
    public Map<Integer, String> readAllQuestions() {
        return getValuesFromCSVFile(questionFilePath);
    }

    @Override
    public Map<Integer, String> readAllAnswers() {
        return getValuesFromCSVFile(answerFilePath);
    }

    private Map<Integer, String> getValuesFromCSVFile(String fileName) {
        Map<Integer, String> questions = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName)); CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                questions.put(Integer.valueOf(record[0]), record[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
