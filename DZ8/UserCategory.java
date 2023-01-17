public class UserCategory extends User {
    protected UserType userType;

    public UserCategory(String nickName, Integer age, String emailAddress, UserType userType) {
        super(nickName, age, emailAddress);
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "User NickName is: " + nickName+ ";\n" +
                "User age is: " + age+ ";\n" +
                "User e-mail: " + emailAddress+ ";\n" +
                "User Role: " + userType + "\n";
    }
}