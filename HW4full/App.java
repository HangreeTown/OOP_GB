public class App {
    Planner planner;
    TaskService taskService;
    ExportService exportService;
    private int currentTask = 0;

    public App(Planner planner, TaskService taskService, ExportService exportService) {
        this.exportService = exportService;
        this.planner = planner;
        this.taskService = taskService;
    }

    public void start() {
        while (true) {
            if (TaskTree.getList().size() > 0) {
                planner.print(TaskTree.getTaskByPriority(currentTask), currentTask);
            }
            switch (planner.getValue()) {
                case ("1"):
                    taskService.getChoice();
                    currentTask = 0;
                    break;
                case ("2"):
                    TaskTree.update();
                    currentTask = 0;
                    break;
                case ("3"):
                    exportService.chooseFormat();
                    break;
                case ("4"):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong enter! Try again");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }
}