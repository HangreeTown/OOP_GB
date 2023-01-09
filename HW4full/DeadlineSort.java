import java.util.Comparator;

public class DeadlineSort implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getDeadline().compareTo(o2.getDeadline());
    }
}