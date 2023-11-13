enum MessageType
{
    TEXT, IMAGE, VOICE, VIDEO, FILE, LOCATION
}

public class Message {
    private MessageType messageType;
    private String messageText;
    private String messageDate;

    public Message(MessageType messsageType, String messageText, String messageDate)
    {
        this.messageDate = messageDate;
        this.messageText = messageText;
        this.messageType = messsageType;
    }

    public MessageType getType()
    {
        return this.messageType;
    }

    public void setType(MessageType messageType)
    {
        this.messageType = messageType;
    }

    public String display()
    {
        return "Date: " + this.messageDate + " Message Text: " + this.messageText;
    }
}
