package org.thakur.ayush.hostelmanagementsystem;

/**
 * Created by win on 13-11-2018.
 */

public class TimeTableObject {

    int TimeTableMessNumber;
    int TimeTableDay;
    String breakfast;
    String lunch;
    String dinner;

    public TimeTableObject() {
    }

    public TimeTableObject(int timeTableMessNumber, int timeTableDay, String breakfast, String lunch, String dinner) {
        TimeTableMessNumber = timeTableMessNumber;
        TimeTableDay = timeTableDay;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public int getTimeTableMessNumber() {
        return TimeTableMessNumber;
    }

    public void setTimeTableMessNumber(int timeTableMessNumber) {
        TimeTableMessNumber = timeTableMessNumber;
    }

    public int getTimeTableDay() {
        return TimeTableDay;
    }

    public void setTimeTableDay(int timeTableDay) {
        TimeTableDay = timeTableDay;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }
}
