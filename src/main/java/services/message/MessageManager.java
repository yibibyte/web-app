/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package services.message;

import entities.Message;
import entities.User;

import java.util.List;

/**
 *  Класс для управления сообщениями
 */
public class MessageManager {
    Message message = new Message();

    public List<String> getMessages() {
        return message.getMessages();
    }

    public Message getMessage() {
        return message;
    }

    // Метод для выполнения операции над сообщением
    public void executeOperation(User user, String message, MessageOperation operation) {
        operation.performOperation(user, message);
    }

    // Метод для вывода всех сообщений
    public void displayMessages() {
        System.out.println("All Messages:");
        getMessages().forEach(System.out::println);
        System.out.println();
    }

    // Метод для добавления сообщения
    public void addMessage(String message) {
        getMessages().add(message);
    }

    // Метод для проверки существования сообщения
    public boolean containsMessage(String message) {
        return getMessages().contains(message);
    }

    // Метод для удаления сообщения
    public void deleteMessage(String message) {
        if (getMessages().contains(message)) {
            getMessages().remove(message);
        }
    }
}
