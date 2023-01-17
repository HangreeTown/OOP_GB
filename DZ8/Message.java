import java.util.Date;

public abstract class Message {
    public Date date;
    public UserCategory user;
    public String text;

    public Message(Date date, UserCategory user, String text){
        this.date = date;
        this.user = user;
        this.text = text;
    }
}