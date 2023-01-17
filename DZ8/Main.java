public class Main {

    public static void main(String[] args) {

        UsersList.addUser(new UserCategory("Nikolay",30,"as@mail.ru", UserType.MODERATOR));

        UsersList.printUsersList();
        View.run();
    }

}