/*
 * Copyright (c) 2024. Thank you for your interest in our company and welcome to our company.
 */

package entities;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private List<String> messages = new ArrayList<>();
    private String message = "";

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
