package com.ivanov.laboratory.models;

import lombok.Data;

@Data
public class Task {

    private final Analyze analyze;

    public Task(Analyze analyze) {
        this.analyze = analyze;
    }
}
