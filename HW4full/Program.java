public class Program {
    public static void main(String[] args) {
        App app = new App(new Planner(), new TaskService(), new ExportService());
        app.start();
    }
}