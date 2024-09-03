package se.lexicon.dao.db;

import se.lexicon.dao.implementation.DBConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MeetingCalendarDBConnection {
    private static final String DB_NAME = "Meeting_calendar_db";
        private static final String JDBC_URL = "jdbc:mysql://localhost:33006/" + DB_NAME;
        private static final String JDBC_USER = "root";
        private static final String JDBC_PASSWORD = "root";
        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            } catch (SQLException e) {
                throw new DBConnectionException("Could not connect to database");
            }
        }
    }

