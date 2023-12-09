package com.example.demo.controller;

import com.example.demo.entity.BotRequest;
import com.example.demo.entity.BotResponse;
import com.example.demo.entity.ChatRequest;
import com.example.demo.entity.Message;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ChatController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.max-completions}")
    private int maxCompletions;

    @Value("${openai.temperature}")
    private double temperature;

    @Value("${openai.max_tokens}")
    private int maxTokens;

    @Value("${openai.api.url}")
    private String apiUrl;

    @RequestMapping(value = "/chat", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BotResponse chat(@RequestBody ChatRequest bot) {
        BotRequest request = new BotRequest(model,
                Arrays.asList(new Message("user", bot.getPrompt())),
                maxCompletions,
                temperature,
                maxTokens);

        BotResponse response = restTemplate.postForObject(apiUrl, request, BotResponse.class);
        return response;
    }
}
