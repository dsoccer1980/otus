package ru.dsoccer1980.dao;

import com.opencsv.CSVReader;
import ru.dsoccer1980.model.QuestionDatabase;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public String findQuestionById(int id) {
        return getValueFromCSVFile("./questions.csv", id);
    }

    @Override
    public String findAnswerById(int id) {
        return getValueFromCSVFile("./answers.csv", id);
    }

    private String getValueFromCSVFile(String fileName, int id) {
        String value = "";
        try (Reader reader = Files.newBufferedReader(Paths.get(fileName)); CSVReader csvReader = new CSVReader(reader);) {
            List<String[]> records = csvReader.readAll();
            String[] strings = records.stream().filter(r -> Integer.valueOf(r[0]) == (id + 1)).findFirst().get();
            value = strings[1];

        } catch (IOException e) {
        }
        return value;
    }
}
