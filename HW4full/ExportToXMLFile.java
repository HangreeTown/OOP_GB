import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToXMLFile {
    public ExportToXMLFile(File file) {

        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<TaskList>\n");
            for (Task task : TaskTree.getList()) {
                strBuilder.append("<task>\n<createDate>");
                strBuilder.append(task.getCreateDate());
                strBuilder.append("</createDate>\n");
                strBuilder.append("<createTime>");
                strBuilder.append(task.getCreateTime());
                strBuilder.append("</createTime>\n");
                strBuilder.append("<deadline>");
                strBuilder.append(task.getDeadline());
                strBuilder.append("</deadline>\n");
                strBuilder.append("<author>");
                strBuilder.append(task.getCreator());
                strBuilder.append("</author>\n");
                strBuilder.append("<taskDescription>");
                strBuilder.append(task.getTask());
                strBuilder.append("</taskDescription>\n</task>\n");
            }
            strBuilder.append("</TaskList>");
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("Error! The tasks were not saved in the file. %s", e);
        }
    }
}