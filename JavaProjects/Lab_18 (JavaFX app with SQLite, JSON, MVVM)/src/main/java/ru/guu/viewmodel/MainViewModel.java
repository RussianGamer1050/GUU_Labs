package ru.guu.viewmodel;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ru.guu.model.User;
import ru.guu.model.UserRepository;

public class MainViewModel {
    private UserRepository userRepository;
    
    public MainViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void importUsersFromJson(String filePath) throws Exception {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<User>>() {}.getType();
        List<User> users = gson.fromJson(new FileReader(filePath), listType);
        for (User user : users) {
            userRepository.addUser(user);
        }
    }

    public void exportUsersFromDb(String filePath) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(userRepository.getUsers());
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        }
    }

    public void addUser(User user) throws Exception {
        userRepository.addUser(user);
    }
    
    public List<User> getAllUsers() throws Exception {
        return userRepository.getUsers();
    }
}