import java.util.ArrayList;
import java.util.List;

public class MessageList {
    public static Integer count = 0;

    private static List<UserMessage> messageList = new ArrayList<>();

    public static void addMessage(UserMessage mes){
        messageList.add(mes);
        count++;
        System.out.println("Message count = " + count + ";\n");
    }

    public static List<UserMessage> getMessageList() {
        return messageList;
    }

    public static void editMessage(Integer index, UserMessage element) {
        for (UserMessage item : messageList) {
            if (item.getMessageID().equals(index)) {
                messageList.set(messageList.indexOf(item), element);
            }
        }
        messageList.set(index, element);
    }
    public static void printMessageList() {
        System.out.println("Message ID" + "  |  " + "User nickname" + "  |  " + "Message text\n");
        for (UserMessage item : messageList) {
            System.out.println("        " + item.getMessageID() + "   |        " + item.user.getName() + "      |   " + item.getMessageText() + "\n");
        }
    }

}