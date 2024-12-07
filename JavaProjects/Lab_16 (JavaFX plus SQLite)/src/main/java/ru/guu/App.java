package ru.guu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private TableView<User> table;
    private ObservableList<User> data;

    private void connectToDatabase() {
        String url = "jbdc:sqlite:users.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to SQLite database.");
                loadUsers();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = DriverManager.getConnection("jbdc:sqlite:users.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                data.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAddUserDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add User");
        dialog.setHeaderText("Enter ");

        dialog.showAndWait().ifPresent(name -> {
            String email = "user@example.com";
            addUserToDatabase(name, email);
            data.add(new User(name, email));
        });
    }

    private void addUserToDatabase(String name, String email) {
    String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db"); 
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void createTableIfNotExists() {
    String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL, " +    
                            "email TEXT NOT NULL);";

    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
        Statement stmt = conn.createStatement()) {
        stmt.execute(createTableSQL);
        System.out.println("Table 'users' is ready.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void start(Stage stage) {
        createTableIfNotExists();

        stage.setTitle("JavaFX SQLite Example");

        table = new TableView<>();
        data = FXCollections.observableArrayList();

        connectToDatabase();

        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        TableColumn<User, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        table.setItems(data);
        table.getColumns().add(nameColumn);
        table.getColumns().add(emailColumn);

        Button addButton = new Button("Add User");
        addButton.setOnAction(e -> showAddUserDialog());

        // Панель для кнопок
        BorderPane root = new BorderPane();
        root.setCenter(table);
        root.setBottom(addButton);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}