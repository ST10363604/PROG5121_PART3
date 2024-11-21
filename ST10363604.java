package com.mycompany.st10363604;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
    
public class ST10363604 {
    
    private static final ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
       String[] options = {"Add Task", "Search Task by Name", "Search Tasks by Developer", 
                            "Delete Task by Name", "Display All Tasks", "Exit"};
        int choice;

        do {
            choice = JOptionPane.showOptionDialog(null, 
                                                  "Task Manager Menu",
                                                  "Task Manager",
                                                  JOptionPane.DEFAULT_OPTION,
                                                  JOptionPane.INFORMATION_MESSAGE,
                                                  null, options, options[0]);

            switch (choice) {
                case 0:
                    addTask();
                    break;
                case 1:
                    searchTaskByName();
                    break;
                case 2:
                    searchTasksByDeveloper();
                    break;
                case 3:
                    deleteTaskByName();
                    break;
                case 4:
                    displayAllTasks();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Exiting Task Manager...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void addTask() {
        String developer = JOptionPane.showInputDialog("Enter Developer Name:");
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        int taskDuration;
        try {
            taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input for task duration.");
            return;
        }
        String[] statuses = {"To Do", "Doing", "Done"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, 
                                                                 "Select Task Status:",
                                                                 "Task Status",
                                                                 JOptionPane.QUESTION_MESSAGE,
                                                                 null, statuses, statuses[0]);

        if (developer != null && taskName != null && taskStatus != null) {
            taskList.add(new Task(developer, taskName, taskDuration, taskStatus));
            JOptionPane.showMessageDialog(null, "Task added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Task creation canceled.");
        }
    }

    private static void searchTaskByName() {
        String name = JOptionPane.showInputDialog("Enter Task Name to Search:");
        if (name == null) return;

        for (Task task : taskList) {
            if (task.getTaskName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null, "Task Found:\n" + task);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void searchTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog("Enter Developer Name to Search:");
        if (developer == null) return;

        StringBuilder result = new StringBuilder();
        for (Task task : taskList) {
            if (task.getDeveloper().equalsIgnoreCase(developer)) {
                result.append(task).append("\n");
            }
        }

        if (result.length() > 0) {
            JOptionPane.showMessageDialog(null, "Tasks Found:\n" + result);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for this developer.");
        }
    }

    private static void deleteTaskByName() {
        String name = JOptionPane.showInputDialog("Enter Task Name to Delete:");
        if (name == null) return;

        boolean removed = taskList.removeIf(task -> task.getTaskName().equalsIgnoreCase(name));

        if (removed) {
            JOptionPane.showMessageDialog(null, "Task deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    private static void displayAllTasks() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder allTasks = new StringBuilder();
        for (Task task : taskList) {
            allTasks.append(task).append("\n");
        }

        JOptionPane.showMessageDialog(null, "All Tasks:\n" + allTasks);
    }
    }
