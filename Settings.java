public class Settings {
    boolean notifications = true;
    User user;

    public Settings(User u) {
        this.user = u;
    }

    public void viewMyProfile() {
        System.out.println(this.user.toString() + " " + this.notifications);
    }

    public boolean setNotification() 
    {
        notifications = !notifications;

        return notifications;
    }

    public void help() {
        System.out.println("0800 801 200");
    }

    public void changePassword(String password) {
        this.user.setPassword(password);
    }

    public void changeNumber(String number) {
        this.user.setNumber(number);
    }

    public void updateStatus(Status status) {
        this.user.status = status;
    }
}
