package com.batch.controller;

import java.util.List;

public class ProductRequest {
    private List<Long> id; // This matches the "id" field in the JSON.

    // Getters and setters
    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }
}
