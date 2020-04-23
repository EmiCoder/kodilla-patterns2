package com.kodilla.kodillapatterns2.observer.homework;

import lombok.Getter;

@Getter
public class Task {

    private final String name;

    public Task(String name) {
        this.name = name;
    }
}
