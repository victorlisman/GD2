import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        User u1 = new User("a", "a", null, null, null, "a");
        User u2 = new User("b", "b", null, null, null, "b");
        User u3 = new User("c", "c", null, null, null, "c");

        List<User> ul = new ArrayList<User>();

        ul.add(u2);
        ul.add(u3);

        GroupChat gc = u1.createGroupChat(ul, "PRIETENI");

        Message m1 = new Message(MessageType.TEXT, "ALOOO", "acum");

        u1.sendMessage("PRIETENI", m1);
        u1.addChat(u3);
        u1.sendMessage(u3.username, m1);

    }
}
