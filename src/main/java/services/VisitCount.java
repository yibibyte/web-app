/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package services;

import java.util.HashMap;
import java.util.Map;

public class VisitCount<User> {
    private final Map<User, Integer> visitCount;

    public VisitCount() {
        visitCount = new HashMap<>();
    }

    public void visit(User user) {
        visitCount.put(user, visitCount.getOrDefault(user, 0) + 1);
    }

    public int getVisitCount(User user) {
        return visitCount.getOrDefault(user, 0);
    }

    public void printVisitCount() {

        // Вывод в консоле
        System.out.println("Visit Count per User:");
        // TODO Сделать вывод на экран пользователю для отображения количества раз сколько он посетил данный ресурс

        for (Map.Entry<User, Integer> entry : visitCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " visits");
        }
    }
}
