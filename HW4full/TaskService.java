import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TaskService {
    Scanner sc = new Scanner(System.in);

    public void getChoice() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("1 - Add task, 2 - Delete task");
            System.out.print("Enter number: ");
            switch (sc.next()) {
                case ("1") -> {
                    addTask();
                    repeatInput = false;
                }
                case ("2") -> {
                    removeTask();
                    repeatInput = false;
                }
                default -> System.out.println("Wrong enter! Try again");
            }
        }
    }

    public void addTask() {
        boolean repeatInput = true;
        String creator;
        String task = new String();
        LocalDate deadline = LocalDate.now();
        while (repeatInput) {
            System.out.println("Enter the deadline date (YYYY-MM-DD):");
            try {
                deadline = LocalDate.parse(sc.nextLine());
                repeatInput = false;
            } catch (Exception ex) {
                System.out.println("Invalid date! Try enter again");
            }
        }
        System.out.println("Enter the name of the task creator");
        creator = sc.nextLine();
        System.out.println("Enter a description of the task");
        task = sc.nextLine();
        String time = String.valueOf(LocalTime.now().getHour()) + ":" + String.valueOf(LocalTime.now().getMinute());
        TaskTree.add(new Task(LocalDate.now(), LocalTime.parse(time), deadline, creator, task));
    }

    private void removeTask() {
        boolean repeatInput = true;
        int id = -1;
        while (repeatInput) {
            System.out.println("Enter the ID of the task you want to delete: ");
            try {
                id = sc.nextInt();
                if (TaskTree.getTaskById(id) != -1) {
                    repeatInput = false;
                    TaskTree.removeById(id);
                } else {
                    System.out.println("Invalid ID! Try enter again");
                }
            } catch (Exception ex) {
                System.out.println("Invalid ID! Try enter again");
            }
        }
    }
}