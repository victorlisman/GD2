import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class User
{
    public String username;
    private String password;
    private String firstName;
    private String lastName;
    protected String birthDate;
    public String email;
    public String phoneNumber;
    public Status status;
    public List<Chat> chats = new ArrayList<Chat>();
    File blockedUsers;
    Settings settings = new Settings(this);

    public User(String lastName, String firstName, String birthDate, String email, String phone, String username)
    {
        this.username = username;

        try {
            this.blockedUsers = new File(this.username + "_blocked.txt");

            if (blockedUsers.createNewFile())
            {
                System.out.println("New user created.");
                    this.firstName = firstName;
                    this.lastName = lastName;
                    this.birthDate = birthDate;
                    this.email = email;
                    this.phoneNumber = phone;
                    this.status = Status.AVAILABLE;
            }
            else 
                System.out.println("User already exists.");
        } catch (IOException e) {
            System.out.println("error!!!!");
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password)
    {
        if (username != this.username)
            return false;

        if (password != this.password)
            return false;

        return true;
    }

    public void logout()
    {
        this.username = null;
        this.password = null;

        System.out.println("Logged out!");
    }

    public void addChat(User u)
    {   
        IndividualChat ic = new IndividualChat();
        ic.partnerUser = u;
        chats.add(ic);
    }

    public void getActiveChatsList() 
    {
        for (Chat c : chats)
            if (c instanceof GroupChat)
            {
                GroupChat gc = (GroupChat)c;

                for (User u : gc.getUsers())
                    if (u.status == Status.AVAILABLE)
                    {
                        System.out.println(gc.getName());
                        break;
                    }
            }
            else 
            {
                IndividualChat ic = (IndividualChat)c;

                if (ic.partnerUser.status == Status.AVAILABLE)
                    System.out.println("Chat with " + ic.partnerUser.username + "is active.");
            }


    }

    public GroupChat createGroupChat(List<User> userList, String name) 
    {
        userList.add(this);
        for (User u : userList)
            if (isBlocked(u.username))
                userList.remove(u);

        GroupChat gc = new GroupChat(name, userList);
        chats.add(gc);

        return gc;
    }

    public void blockUser(String username) {
        try {
            FileWriter myWriter = new FileWriter(this.username + "_blocked.txt");
            myWriter.write(username + "\n");
            myWriter.close();

            System.out.println("Added blocked user to file: " + username);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }

    private boolean isBlocked(String username) {
        try {
            Scanner myReader = new Scanner(blockedUsers);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (username.equals(data))
                    return true;
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("error");
        }
        
        

        return false;
    }

    public void sendMessage(String name, Message message) {
        for (Chat c : chats)
            if (c instanceof GroupChat)
            {
                GroupChat gc = (GroupChat) c;

                if (gc.getName().equals(name))
                    gc.receiveMessage(message, this);
            }
            else
            {
                IndividualChat ic = (IndividualChat) c;

                if (ic.partnerUser.username.equals(name))
                    ic.receiveMessage(message, this);

            }
    }

    public void search(String text) {

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumber(String number) {
        this.phoneNumber = number;
    }

    public void leaveGroup(String name) {
        GroupChat temp = null;
        
        for (Chat c : chats) {
            if (c instanceof GroupChat)
            {
                GroupChat gc = (GroupChat) c;

                if (gc.getName().equals(name))
                {
                    gc.getUsers().remove(this);
                    temp = gc;
                }
            }
        }

        this.chats.remove(temp);
    }


    @Override
    public String toString()
    {
        return this.username + " " + this.birthDate + " " + this.firstName + " " + this.lastName + " " + this.phoneNumber + " " + this.email + " ";
    }

}