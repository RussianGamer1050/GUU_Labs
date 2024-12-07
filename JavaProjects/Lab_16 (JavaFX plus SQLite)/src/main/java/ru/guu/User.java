package ru.guu;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty name;
    private final StringProperty email;
    private final int id;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
    }

    public User(String name, String email) {
        this.id = -1;
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getId() {
        return id;
    }
}