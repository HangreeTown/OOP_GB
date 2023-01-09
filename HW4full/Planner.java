import java.time.LocalDate;
import java.util.Scanner;

public class Planner {
    Scanner sc = new Scanner(System.in);

    public String getValue() {
        System.out.println("1 - add/delete task\n2 - update tasks list\n3 - export task list to file\n4 - exiting the program");
        System.out.print("Enter number: ");
        return sc.next();
    }

    public void print(Task task, int priority) {
        System.out.println("----------------------------------------");
        System.out.printf("Priority (0 - the highest): %d\n", priority);
        System.out.printf("Task ID: \t\t%d\n", task.getId());
        System.out.printf("Days to Deadline: \t%s\n", task.getDeadline().toEpochDay() - LocalDate.now().toEpochDay());
        System.out.printf("Deadline: \t\t%s\n", task.getDeadline());
        System.out.printf("Date of creations: \t%s\n", task.getCreateDate());
        System.out.printf("Time of creations: \t%s\n", task.getCreateTime());
        System.out.printf("Creator of task: \t%s\n", task.getCreator());
        System.out.printf("Task: \t\t\t%s\n", task.getTask());
        System.out.println("----------------------------------------");
    }
}