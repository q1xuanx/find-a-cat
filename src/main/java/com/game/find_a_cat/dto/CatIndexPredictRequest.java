package com.game.find_a_cat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatIndexPredictRequest {

    public int x;
    public int y;

    @ConstructorProperties({"x", "y"})
    public CatIndexPredictRequest(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
