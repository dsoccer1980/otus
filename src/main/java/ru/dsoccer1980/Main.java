package ru.dsoccer1980;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.dsoccer1980.service.RunTesting;

import java.io.*;

@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        RunTesting runTesting = context.getBean(RunTesting.class);
        runTesting.run();

        context.close();
    }
}
