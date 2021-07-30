package com.example.demo;

import com.example.demo.enumerators.StaticKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class SpringbootExampleApplication {

    private static final Logger logger = Logger.getLogger(SpringbootExampleApplication.class.getName());

    private static void openHomePage() {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(StaticKeys.COMMAND_OPEN_CHROME.toString());
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExampleApplication.class, args);
        openHomePage();
    }

}
