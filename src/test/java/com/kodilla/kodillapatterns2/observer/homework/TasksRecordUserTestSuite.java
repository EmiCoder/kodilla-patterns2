package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TasksRecordUserTestSuite {

    @Test
    public void testUpdate() {
        StudentRecord johnSmith = new StudentRecord("John Smith");
        StudentRecord alanBaldwin = new StudentRecord("Alan Baldwin");

        Mentor mentor_1 = new Mentor("Adam Nowak");
        Mentor mentor_2 = new Mentor("Anna Bykowska");

        johnSmith.registerObserver(mentor_1);
        johnSmith.registerObserver(mentor_2);

        alanBaldwin.registerObserver(mentor_2);

        johnSmith.addTask(new Task("Prepare TaskController"));
        johnSmith.addTask(new Task("Check the spec."));
        johnSmith.addTask(new Task("Prepare the tests"));
        alanBaldwin.addTask(new Task("Read the documentation"));
        alanBaldwin.addTask(new Task("Refactor the ProductClass"));

        assertEquals(3, mentor_1.getUpdateCount());
        assertEquals(5, mentor_2.getUpdateCount());
        assertEquals(2, johnSmith.getObservers().size());

        johnSmith.removeObserver(mentor_1);
        assertEquals(1, johnSmith.getObservers().size());
    }
 }
