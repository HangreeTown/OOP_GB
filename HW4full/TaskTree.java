import java.util.ArrayList;
import java.util.List;

public class TaskTree {
    private final static List<Task> list = new ArrayList<>();

    public static List<Task> getList() {
        return list;
    }

    public static void add(Task task) {
        list.add(task);
        update();
    }

    public static void addAll(List<Task> tasks) {
        list.addAll(tasks);
    }

    public static Task getTaskByPriority(int priority) {
        return list.get(priority);
    }

    public static Integer getTaskById(int id) {
        int i = 0;
        boolean notFind = true;
        while (notFind && i < list.size()) {
            if (list.get(i).getId() == id) {
                notFind = false;
            } else {
                i++;
            }
        }
        if (notFind) {
            i = -1;
        }
        return i;
    }

    public static void removeById(int id) {
        if (getTaskById(id) > -1) {
            int index = getTaskById(id);
            list.remove(index);
        }
    }

    public static void update() {
        list.sort(new DeadlineSort());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Task element : list) {
            str.append(element + "\n");
        }
        return str.toString();
    }
}