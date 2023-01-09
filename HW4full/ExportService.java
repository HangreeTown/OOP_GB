import java.io.File;
import java.util.Scanner;

public class ExportService {
    public String path = "C:/Users/Akuloff/Desktop/Geek_Brains/1_Quarter/010_OOP/OOP_Home_works_other/OOP_HW4_2/TaskList";
    Scanner sc = new Scanner(System.in);

    public void chooseFormat() {
        boolean repeatInput = true;
        while (repeatInput) {
            System.out.println("Export to: 1 - CSV, 2 - JSON, 3 - XML");
            System.out.print("Enter number: ");
            switch (sc.next()) {
                case ("1") -> {
                    exportToCSVFile();
                    repeatInput = false;
                }
                case ("2") -> {
                    exportToJSONFile();
                    repeatInput = false;
                }
                case ("3") -> {
                    exportToXMLFile();
                    repeatInput = false;
                }
                default -> System.out.println("Wrong enter! Try again");
            }
        }
    }

    public void exportToCSVFile() {
        path += ".csv";
        ExportToCSVFile exp = new ExportToCSVFile(new File(path));
    }

    public void exportToJSONFile() {
        path += ".json";
        ExportToJSONFile exp = new ExportToJSONFile(new File(path));
    }

    public void exportToXMLFile() {
        path += ".xml";
        ExportToXMLFile exp = new ExportToXMLFile(new File(path));
    }
}