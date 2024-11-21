package com.mycompany.st10363604;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private String developer;
    private String taskName;
    private int taskDuration;
    private String taskStatus;

    // Constructor
    public Task(String developer, String taskName, int taskDuration, String taskStatus) {
        this.developer = developer;
        this.taskName = taskName;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    // Getters
    public String getDeveloper() {
        return developer;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    // Override toString to display task details
    @Override
    public String toString() {
        return "Developer: " + developer + ", Task Name: " + taskName +
               ", Task Duration: " + taskDuration + " hours, Task Status: " + taskStatus;
    }
}
