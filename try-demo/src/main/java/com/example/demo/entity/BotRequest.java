package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BotRequest {

    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;
    private int max_tokens;

    // getters and setters
}
