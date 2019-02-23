package ru.dsoccer1980.dao;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class QuestionDaoCSVImpl implements QuestionDao {
    private final String questionFilePath = "./questions.csv";
    private final String answerFilePath = "./answers.csv";

    @Override
    public String findQuestionById(int id) {
        return getValueFromCSVFile(questionFilePath, id);
    }

    @Override
    public String findAnswerById(int id) {
        return getValueFromCSVFile(answerFilePath, id);
    }

    private String getValueFromCSVFile(String fileName, int id) {
        String value = "";
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName)); CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> records = csvReader.readAll();
            String[] strings = records.stream().filter(r -> Integer.valueOf(r[0]) == (id + 1)).findFirst().get();
            value = strings[1];

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
