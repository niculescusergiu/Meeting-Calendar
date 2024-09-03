package se.lexicon.dao.implementation;

import se.lexicon.dao.CalendarDAO;
import se.lexicon.model.Calendar;

import java.util.Collection;
import java.util.Optional;

public class CalendarDAOImpl implements CalendarDAO {
    @Override
    public Calendar createCalendar(String title, String username) {
        return null;
    }

    @Override
    public Optional<Calendar> findById() {
        return Optional.empty();
    }

    @Override
    public Collection<Calendar> findCalendarByUsername(String username) {
        return null;
    }

    @Override
    public Optional<Calendar> findByTitleAndUsername(String title, String username) {
        return Optional.empty();
    }

    @Override
    public boolean deleteCalendar(int id) {
        return false;
    }
}
