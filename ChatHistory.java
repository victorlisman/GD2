import java.util.ArrayList;
import java.util.List;

public class ChatHistory {
    private String sender;
    private List<Message> messageList = new ArrayList<Message>();

    public List<Message> getMessageList()
    {
        return this.messageList;
    }

    public void addMessage(Message message)
    {
        this.messageList.add(message);
    }
}