package se.lexicon.dao.implementation;

import se.lexicon.dao.UserDAO;
import se.lexicon.dao.db.MeetingCalendarDBConnection;
import se.lexicon.exception.AuthFailedException;
import se.lexicon.exception.MySQLException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public User createUser(String username) {
        String query = "insert into users(username, _password) values(?,?)";
        try(
                Connection connection = MeetingCalendarDBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ){


            User user = new User(username);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0){
                throw new MySQLException("Creating user failed, no rows affected.");
            }
            return user;
        }catch(SQLException e){
            throw new MySQLException("Error occurred while creating user: " + username, e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String query = "select * from users where username = ?";


        try(

                Connection connection  = MeetingCalendarDBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ){
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String foundUsername = resultSet.getString("username");
                String foundPassword = resultSet.getString("password");
                boolean foundExpired = resultSet.getBoolean("expired");
                User user = new User(foundUsername, foundPassword, foundExpired);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        }catch(SQLException e){
            throw new MySQLException("Error occurred while finding user by username: " + username, e);
        }
    }

    @Override
    public boolean authenticate(User user) throws AuthFailedException, UserExpiredException {
        String query = "Select * from users where username = ? and _password = ?";
        try(
                Connection connection = MeetingCalendarDBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                boolean isExpired = resultSet.getBoolean("expired");
                if(isExpired){
                    throw new UserExpiredException("User is expired. Username: " + user.getUsername());
                }
            } else {
                throw new AuthFailedException("Authentication failed. Invalid credentials.");
            }
            return true;
        }catch(SQLException e){
            throw new MySQLException("Error occurred while authenticating user by username: " + user.getUsername());
        }
    }
}
