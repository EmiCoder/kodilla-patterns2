package com.kodilla.kodillapatterns2.observer.homework;



import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class TasksRecord implements Observable{

    private final List<Observer> observers;
    private final List<Task> tasks;
    private final String name;

    public TasksRecord(String name) {
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
            observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
            observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
