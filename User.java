public abstract class User {
    protected static String nickName;
    protected static Integer age;
    protected static String emailAddress;

    public User(String nickName, Integer age, String emailAddress) {
        User.nickName = nickName;
        User.age = age;
        User.emailAddress = emailAddress;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Integer getUserAge() {
        return age;
    }

}
