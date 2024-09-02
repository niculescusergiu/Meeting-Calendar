package se.lexicon.model;

import se.lexicon.model.Calendar;

import java.time.LocalDateTime;

public class Meeting {
    private int id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private Calendar calendar;


   // Taking data from the user from console to create a meeting
    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    //Save meeting to the database
    public Meeting(int id, String title, LocalDateTime startTime, LocalDateTime endTime, String description, Calendar calendar) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.calendar = calendar;
    }

    //Fetch data from the database
    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description, Calendar calendar) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.calendar = calendar;
    }

    //Returning all meeting information without calendar
    public Meeting(int id, String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getCalendar() {
        return calendar;
    }


    private void timeValidation(){
        if (startTime.isAfter(endTime)){
            throw new IllegalArgumentException("Start time can't be after end time");
        }
        if (this.endTime.isBefore(this.startTime)){
            throw new IllegalArgumentException("End time can't be before start time");
        }
    }

    public String meetingInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Meeting info: ").append("\n");
        stringBuilder.append("ID: ").append(id).append("\n");
        stringBuilder.append("Title: ").append(title).append("\n");
        stringBuilder.append("Start Time: ").append(startTime).append("\n");
        stringBuilder.append("End Time: ").append(endTime).append("\n");
        stringBuilder.append("Description: ").append(description).append("\n");
        stringBuilder.append("Calendar title ").append(calendar.getTitle()).append("\n");

        return stringBuilder.toString();
    }
}
