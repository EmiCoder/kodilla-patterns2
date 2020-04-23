package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TasksRecordUserTestSuite {

    @Test
    public void testUpdate() {
        TasksRecord record_1 = new Student_1();
        TasksRecord record_2 = new Student_2();

        Mentor mentor_1 = new Mentor("Adam Nowak");
        Mentor mentor_2 = new Mentor("Anna Bykowska");

        record_1.registerObserver(mentor_1);
        record_1.registerObserver(mentor_2);

        record_2.registerObserver(mentor_2);

        record_1.addTask(new Task("Prepare TaskController"));
        record_1.addTask(new Task("Check the spec."));
        record_1.addTask(new Task("Prepare the tests"));
        record_2.addTask(new Task("Read the documentation"));
        record_2.addTask(new Task("Refactor the ProductClass"));

        assertEquals(3, mentor_1.getUpdateCount());
        assertEquals(5, mentor_2.getUpdateCount());
        assertEquals(2, record_1.getObservers().size());

        record_1.removeObserver(mentor_1);
        assertEquals(1, record_1.getObservers().size());
    }
 }
