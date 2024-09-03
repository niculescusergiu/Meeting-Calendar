package se.lexicon.dao;

import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDAO {
    Meeting createMeeting(Meeting meeting);
    Optional<Meeting> findById(int meetingId);



    //Select * from meeting
    Collection<Meeting> findAllMeetingsByCalendarId(int calendarId);
}
