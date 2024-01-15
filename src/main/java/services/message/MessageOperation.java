/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package services.message;

import entities.User;

/**
 * Функциональный интерфейс для операций над сообщением
 */
@FunctionalInterface
public interface MessageOperation {
    void performOperation(User user, String message);
}
