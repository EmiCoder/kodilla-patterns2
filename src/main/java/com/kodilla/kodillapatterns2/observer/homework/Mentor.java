package com.kodilla.kodillapatterns2.observer.homework;

import lombok.Getter;

@Getter
public class Mentor implements Observer {

    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(TasksRecord tasksRecord) {
        System.out.println(mentorName + " has new message in record " + tasksRecord.getName() + ", total " + tasksRecord.getTasks().size() + ((tasksRecord.getTasks().size() > 1) ? " record" : " records"));
        updateCount++;
    }
}
