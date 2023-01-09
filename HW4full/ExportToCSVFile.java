import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToCSVFile {
    public ExportToCSVFile(File file) {
        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            for (Task task : TaskTree.getList()) {
                strBuilder.append(task.getCreateDate());
                strBuilder.append(";" + " ");
                strBuilder.append(task.getCreateTime());
                strBuilder.append(";" + " ");
                strBuilder.append(task.getDeadline());
                strBuilder.append(";" + " ");
                strBuilder.append(task.getCreator());
                strBuilder.append(";" + " ");
                strBuilder.append(task.getTask());
                strBuilder.append("\n");
            }
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Error! The tasks were not saved in the file. %s", e);
        }
    }
}