package org.ardaY.todolist;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void TaskAdd() {
        String user_taskName;
        String user_deadline;
        System.out.println("Name of the new task: ");
        user_taskName = scanner.nextLine();
        System.out.println("Deadline of the " + user_taskName + ": (If there is not any deadline enter 0)");
        user_deadline = scanner.nextLine();
        Task newtask;
        if (user_deadline.equals("0")) {
            newtask = new Task(user_taskName,false);
        }
        else {
            newtask = new Task(user_taskName,false, user_deadline);
        }
        System.out.print("New task: "+ newtask.getName() + " added \n");
        tasks.add(newtask);
    }

    public static void TaskDisplay() {
        if (!tasks.isEmpty()) {
            System.out.println("Tasks: (Name-Deadline-Done?) ");
            for(int i = 0; i < tasks.size(); i++) {
                System.out.print(i+1 + " " + tasks.get(i).getName() + " ");
                if (tasks.get(i).getDeadline() != null) {
                    System.out.print(tasks.get(i).getDeadline() + " ");
                }
                System.out.print(tasks.get(i).getIsDone() + "\n");
            }
            System.out.println("Press 1 to mark as done any number to continue: ");
            int user_pick = scanner.nextInt();
            scanner.nextLine();
            if (user_pick == 1) {
                TaskMarkDone();
            }
            else {
                return;
            }
        }
        else { System.out.println("No tasks added!"); }
    }

    public static void TaskMarkDone() {
        System.out.println("Choose task to mark as done");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print(i + 1 + " " + tasks.get(i).getName() + " \n");
        }
        try {
            int user_pick = scanner.nextInt();
            user_pick = user_pick - 1;
            tasks.get(user_pick).setIsDone(!tasks.get(user_pick).getIsDone());
            System.out.println(tasks.get(user_pick).getName() +" marked as tasks.get(user_pick).getIsDone()");
        } catch (Exception a) {
            System.out.println("Pick a available number");
        }
    }

    public static void TaskRemove() {
        System.out.println("Choose to remove task: (write id number of the task)");
        for(int i = 0; i < tasks.size(); i++) {
            System.out.print(i+1 + " " + tasks.get(i).getName() + " \n");
        }
        try {
            int user_pick = scanner.nextInt();
            user_pick = user_pick - 1;
            System.out.print("Task: " + tasks.get(user_pick).getName() + " removed \n");
            scanner.nextLine();
            tasks.remove(user_pick);
        }
        catch (Exception c)
        {
            System.out.println("Pick a available number");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to To-do-list!");
        int user_Pick = 0;
        for(;;) {
            System.out.println("Choose form menu: 1- Add Task 2- Show Tasks 3- Remove Task 4- Exit");
            try {
                user_Pick = scanner.nextInt();
                scanner.nextLine();
                switch (user_Pick) {
                    case 1:
                        TaskAdd();
                        continue;

                    case 2:
                        TaskDisplay();
                        continue;

                    case 3:
                        TaskRemove();
                        continue;

                    case 4:
                        System.out.println("Exiting");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Write 1,2,3 or 4!");
                        continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Write NUMBER from 1 to 4");
                scanner.nextLine();
            }
        }
    }
}