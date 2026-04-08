package com.game.find_a_cat.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CatHidingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void drawBoard() throws Exception {
        mockMvc.perform(get("/cat/draw-board"))
                .andExpect(status().isOk());
    }

    @Test
    void checkResult() throws Exception {
        String body = """
                {
                    "x" : 2,
                    "y" : 1
                }
                """;
        mockMvc.perform(post("/cat/check-result")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").exists())
                .andExpect(jsonPath("$.message").exists());
    }
}