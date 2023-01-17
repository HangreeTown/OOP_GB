import java.sql.Date;
import java.util.Scanner;

public class View {
    public static void run() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input your NickName:");
        String nick = sc.nextLine();

        while (true) {

            System.out.println(
                    "Choice ToDo:\n1 - Add user\n2 - Remove user\n3 - Write message\n4 - Edit message\n5 - Search message\n6 - Print messages\n7 - Search message");
            String choice = sc.nextLine();
            System.out.println(UsersList.getUser(nick).userType+ "--------------------\n");
            switch (choice) {
                case ("1") -> {

                    if (UsersList.getUser(nick).userType.equals(UserType.ADMIN)) {

                        System.out.println("Input NickName for new user:");
                        String name = sc.nextLine();
                        System.out.println("Input age:");
                        Integer age = Integer.parseInt(sc.nextLine());
                        System.out.println("Input e-mail:");
                        String email = sc.nextLine();
                        System.out.println(
                                "Input user type\n1 - USER\n2 - ADMIN\n3 - MODERATOR\n4 - GUEST");
                        String userType = sc.nextLine();

                        switch (userType) {
                            case ("1") -> {
                                UsersList.addUser(new UserCategory(name,age, email, UserType.USER));
                                break;
                            }
                            case ("2") -> {
                                UsersList.addUser(new UserCategory(name,age, email, UserType.ADMIN));
                                break;
                            }
                            case ("3") -> {
                                UsersList.addUser(new UserCategory(name,age, email, UserType.MODERATOR));
                                break;
                            }
                            case ("4") -> {
                                UsersList.addUser(new UserCategory(name,age, email, UserType.GUEST));
                                break;
                            }
                            default -> System.out.println("ERROR INPUT!");

                        }

                    } else {
                        System.out.println("Access ERROR!");
                    }
                }
                case ("2") -> {

                    if (UsersList.getUser(nick).getUserType().equals(UserType.ADMIN)) {
                        System.out.println("Input NickName for remove: ");
                        String nickName = sc.nextLine();
                        UsersList.removeUser(nickName);
                    } else {
                        System.out.println("Access ERROR!");
                    }

                }

                case ("3") -> {
                    String inputMessage = sc.nextLine();
                    Date date = new Date(System.currentTimeMillis());
                    MessageList.addMessage(new UserMessage(MessageList.count, date,
                            UsersList.getUser(nick), inputMessage));
                }
                case ("4") -> {
                    System.out.println("Input message number for edit: ");
                    Integer messageID = sc.nextInt();
                    System.out.println("Input new text: ");
                    String messageText = sc.nextLine();
                    Date date = new Date(System.currentTimeMillis());
                    MessageList.editMessage(messageID, new UserMessage(MessageList.count, date,
                            UsersList.getUser(nick), messageText));
                }
                case ("5") -> {
                    String search = sc.nextLine();
                    for (UserMessage item : MessageList.getMessageList()) {
                        if (item.text.contains(search)) {
                            System.out.println(item.date + " " + item.user + " " + item.text);
                        }
                    }
                }
                case ("6") -> {
                    MessageList.printMessageList();
                    break;
                }
                case ("7") -> {
                    System.out.println("Goodbye!");
                    break;
                }
            }
        }
    }
}