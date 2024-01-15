/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package services;

//import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReadWriteFile {

    private static final Logger logger = LoggerFactory.getLogger(ReadWriteFile.class);

       /* // Имя файла для чтения и записи
        String fileName = "visit.txt";

        // Запись в файл
        String initialContent = "This is the start content.";
        writeToFile(fileName, initialContent);
        logTimeAndAction("Write to file");

        // Чтение из файла
        String content = readFromFile(fileName);
        logTimeAndAction("Read from file");
        logger.debug("Original Content: {}", content);

        // Изменение текста
        String modifiedContent = modifyContent(content);
        logTimeAndAction("Modify content");
        logger.debug("Modified Content: {}", modifiedContent);

        // Запись измененного текста обратно в файл
        writeToFile(fileName, modifiedContent);
        logTimeAndAction("Write modified content to file");

        // Повторное чтение и вывод измененного файла
        String finalContent = readFromFile(fileName);
        logTimeAndAction("Read modified content from file");
        logger.debug("Final Content: {}", finalContent);*/

    // Метод для записи в файл
    private static void writeToFile(String fileName, String content) {
        try (Writer writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            logger.error("Error writing to file", e);
        }
    }

    // Метод для чтения из файла
    private static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (Reader reader = new BufferedReader(new FileReader(fileName))) {
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
        } catch (IOException e) {
            logger.error("Error reading from file", e);
        }
        return content.toString();
    }

    // Метод для модификации текста (просто добавим "Modified ")
    private static String modifyContent(String originalContent) {
        return "Modified " + originalContent;
    }

    // Метод для логирования времени и действия
    private static void logTimeAndAction(String action) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        logger.info("[{}] {}", formattedDateTime, action);
    }
}
