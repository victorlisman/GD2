import java.util.ArrayList;
import java.util.List;

public abstract class Chat {
    private boolean chatStatus;
    private String chatType;
    protected static int id = 0;
    public List<ChatHistory> chatHistory = new ArrayList<ChatHistory>();

    public String getChatType()
    {
        return this.chatType;
    }

    public void setChatType(String chatType)
    {
        this.chatType = chatType;
    }

    public boolean getChatStatus()
    {
        return this.chatStatus;
    }

    public void setChatStatus(boolean chatStatus)
    {
        this.chatStatus = chatStatus;
    }

    public abstract void receiveMessage(Message message, User u);

    // Auth email
    public void sentERequest(String email)
    {
        System.out.println(Math.random() * 100000);
    }

    // Auth phone
    public void sentMRequest(String phone)
    {
        System.out.println(Math.random() * 10000);
    }
}
