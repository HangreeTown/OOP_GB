import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Task {
    private static int idCount = 0;
    private LocalDate createDate;
    private LocalTime createTime;
    private LocalDate deadline;
    private String creator;
    private String task;
    private int id;

    public Task(LocalDate createDate, LocalTime createTime, LocalDate deadline, String creator, String task) {
        this.createDate = createDate;
        this.createTime = createTime;
        this.deadline = deadline;
        this.task = task;
        this.creator = creator;
        this.id = ++idCount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getCreator() {
        return creator;
    }

    public String getTask() {
        return task;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        Period p = Period.between(LocalDate.now(), deadline);
        return "Task{" +
                "id=" + id +
                ", days to deadline=" + p.getYears() + "y:" + p.getMonths() + "m:" + p.getDays() +
                "d, createDate=" + createDate +
                ", createTime=" + createTime +
                ", deadline=" + deadline +
                ", creator='" + creator + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}