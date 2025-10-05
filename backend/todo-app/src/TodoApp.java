import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=== To-Do List ===");
        System.out.println("1. Add task");
        System.out.println("2. List tasks");
        System.out.println("3. Complete task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addTask() {
        System.out.print("Task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");
            return;
        }

        System.out.println("\nYour tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void completeTask() {
        listTasks();
        if (tasks.isEmpty())
            return;

        System.out.print("Task number to complete: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markAsCompleted();
            System.out.println("Task completed!");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}
