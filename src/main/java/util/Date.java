package util;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String stringDate) {
        String[] date = stringDate.split("/");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }
}