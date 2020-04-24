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
    public void update(StudentRecord studentRecord) {
        System.out.println(mentorName + " has new message in record " + studentRecord.getName() + ", total " + studentRecord.getTasks().size() + ((studentRecord.getTasks().size() > 1) ? " record" : " records"));
        updateCount++;
    }
}
