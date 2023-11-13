import java.util.ArrayList;
import java.util.List;

public class GroupChat extends Chat
{
    private String groupName;
    private List<User> usersList = new ArrayList<User>();
    private int id;
    private boolean groupChatStatus;

    public GroupChat(String groupName, List<User> uL)
    {
        this.groupName = groupName;
        this.usersList = uL;
        Chat.id++;
        this.id = Chat.id;
        
    }

    public int getId()
    {
        return id;
    }

    public List<User> getUsers()
    {
        return this.usersList;
    }

    public String getName()
    {
        return this.groupName;
    }

    public void receiveMessage(Message message, User u) {
        System.out.println(u.username + " " + message.display());
    }

    public void addFriend(User u) {
        usersList.add(u);
    }

    public void removeFriend(User u) {
        usersList.remove(u);
    }

    public void connectSession() {
        this.setChatStatus(true);
    }


}