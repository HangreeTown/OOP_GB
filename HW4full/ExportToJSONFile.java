import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToJSONFile {
    public ExportToJSONFile(File file) {
        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("{");
            int iterator = 1;
            for (Task task : TaskTree.getList()) {
                strBuilder.append("\"task");
                strBuilder.append(iterator);
                strBuilder.append("\":{\"createDate\":\"");
                strBuilder.append(task.getCreateDate());
                strBuilder.append("\",\"createTime\":\"");
                strBuilder.append(task.getCreateTime());
                strBuilder.append("\",\"deadline\":\"");
                strBuilder.append(task.getDeadline());
                strBuilder.append("\",\"author\":\"");
                strBuilder.append(task.getCreator());
                strBuilder.append("\",\"description\":\"");
                strBuilder.append(task.getTask());
                strBuilder.append("\"},");
                strBuilder.append("\n");
                iterator++;
            }
            strBuilder.setLength(strBuilder.length() - 1);
            strBuilder.append("}");
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Error! The tasks were not saved in the file. %s", e);
        }
    }
}