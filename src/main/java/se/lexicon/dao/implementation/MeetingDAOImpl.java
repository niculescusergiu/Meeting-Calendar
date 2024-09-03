package se.lexicon.dao.implementation;

import se.lexicon.dao.MeetingDAO;
import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public class MeetingDAOImpl implements MeetingDAO {
    @Override
    public Meeting createMeeting(Meeting meeting) {
        return null;
    }

    @Override
    public Optional<Meeting> findById(int meetingId) {
        return Optional.empty();
    }

    @Override
    public Collection<Meeting> findAllMeetingsByCalendarId(int calendarId) {
        return null;
    }
}
