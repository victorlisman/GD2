public class IndividualChat extends Chat{
    public User partnerUser;

    public void receiveMessage(Message message, User u) {
        System.out.println(u.username + " " + message.display());
        
        ChatHistory chatHistory = new ChatHistory();

        chatHistory.addMessage(message);
    }
}
