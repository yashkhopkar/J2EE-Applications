package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.M_93_Friend;

public class FriendDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public FriendDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    // create database connection
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    // disconnect from database
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    // method to retrieve all friends from the table
    public List<M_93_Friend> getAllFriends() throws SQLException {
        List<M_93_Friend> friends = new ArrayList<>();
        String sql = "SELECT * FROM friends";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            String color = resultSet.getString("color");
            M_93_Friend friend = new M_93_Friend();
            friend.setId(id);
            friend.setName(name);
            friend.setEmail(email);
            friend.setAge(age);
            friend.setColor(color);
            friends.add(friend);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return friends;
    }

    // method to insert a new friend into the table
    public boolean insertFriend(M_93_Friend friend) throws SQLException {
        String sql = "INSERT INTO friends (name, email, age, color) VALUES (?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, friend.getName());
        statement.setString(2, friend.getEmail());
        statement.setInt(3, friend.getAge());
        statement.setString(4, friend.getColor());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    // method to delete a friend from the table
    public boolean deleteFriend(int friendId) throws SQLException {
        String sql = "DELETE FROM friends WHERE id = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, friendId);
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
}
