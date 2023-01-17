import java.util.ArrayList;
import java.util.List;

public class UsersList {
    private static List<UserCategory> userList= new ArrayList<>();

    public static void addUser(UserCategory user){
        userList.add(user);
        System.out.println("User "+ user.getNickName() +" successfully added;\n");
    }
    public static void removeUser(String nickName) {
        System.out.println("User " + nickName + " deleted.");
        try {

            for (UserCategory item : userList) {
                if (item.getNickName().equals(nickName)) {
                    userList.remove(item);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR for delete");
        }

    }

    public static UserCategory getUser(String name) {
        UserCategory temp = new UserCategory("Noname",00,"no_email", UserType.ADMIN);
        for (UserCategory item : userList) {
            if (item.getNickName().equals(name)) {
                temp = item;
            }
        }

        return temp;

    }
    public static void printUsersList() {
        for (UserCategory item : userList) {
            System.out.println(item.getName());
        }
    }
}