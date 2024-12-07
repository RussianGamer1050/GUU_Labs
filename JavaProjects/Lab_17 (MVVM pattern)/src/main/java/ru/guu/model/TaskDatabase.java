package ru.guu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDatabase {
    private Connection connection;

    public TaskDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");
        createTableIfNotExists();
    }

    private void createTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "completed BOOLEAN NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (name, completed) VALUES(?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, task.getName());
            pstmt.setBoolean(2, task.isCompleted());
            pstmt.executeUpdate();
        }
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tasks.add(new Task(rs.getInt("id"), rs.getString("name"), rs.getBoolean("completed")));
            }
        }

        return tasks;
    }

    public void deleteTask(int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public void updateTask(Task task) throws SQLException {
        String sql = "UPDATE tasks SET name = ?, completed = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, task.getName());
            pstmt.setBoolean(2, task.isCompleted());
            pstmt.setInt(3, task.getId());
            pstmt.executeUpdate();
        }
    }
}