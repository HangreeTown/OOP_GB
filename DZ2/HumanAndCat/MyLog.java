package HumanAndCat;

import java.util.ArrayList;
import java.util.List;

public class MyLog {

    private List<String> log = new ArrayList<>();

    public void append(String event) {
        log.add(event);
    }

    public void viewEvents() {
        for (var item : log){
            System.out.println(item);
        }
    }
}