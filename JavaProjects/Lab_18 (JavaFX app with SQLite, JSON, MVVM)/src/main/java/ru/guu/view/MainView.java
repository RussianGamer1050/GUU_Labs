package ru.guu.view;

import java.io.File;
import java.util.Optional;

import ru.guu.model.User;
import ru.guu.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;

public class MainView {

    @FXML
    private ListView<String> userListView;

    private MainViewModel viewModel;

    public void setViewModel(MainViewModel viewModel) {
        this.viewModel = viewModel;
        updateUserList(); // Загрузка данных при старте
    }

    @FXML
    private void onImportClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите JSON-файл для импорта");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File file = fileChooser.showOpenDialog(userListView.getScene().getWindow());
        if (file != null) {
            try {
                // Импорт данных через ViewModel
                viewModel.importUsersFromJson(file.getAbsolutePath());
                showInfo("Импорт выполнен успешно", "Пользователи успешно добавлены в базу данных.");
                updateUserList();
            } catch (Exception e) {
                showError("Ошибка импорта", "Не удалось импортировать пользователей: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onExportClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите место для сохранения JSON-файла");
        fileChooser.setInitialFileName("users.json");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File file = fileChooser.showSaveDialog(userListView.getScene().getWindow());
        if (file != null) {
            try {
                viewModel.exportUsersFromDb(file.getAbsolutePath());
                showInfo("Экспорт выполнен успешно", "Пользователи успешно экспортированы в JSON-файл.");
            } catch (Exception e) {
                showError("Ошибка экспорта", "Не удалось экспортировать пользователей: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void onAddUserClicked() {
        TextInputDialog idDialog = new TextInputDialog();
        idDialog.setTitle("Добавление пользователя");
        idDialog.setHeaderText("Введите ID пользователя");
        idDialog.setContentText("ID:");

        Optional<String> idInput = idDialog.showAndWait();
        if (idInput.isEmpty()) return;

        int id;
        try {
            id = Integer.parseInt(idInput.get());
        } catch (NumberFormatException e) {
            showError("Ошибка ввода", "ID должен быть числом.");
            return;
        }

        TextInputDialog nameDialog = new TextInputDialog();
        nameDialog.setTitle("Добавление пользователя");
        nameDialog.setHeaderText("Введите имя пользователя");
        nameDialog.setContentText("Имя:");
        Optional<String> nameInput = nameDialog.showAndWait();
        if (nameInput.isEmpty()) return;

        TextInputDialog emailDialog = new TextInputDialog();
        emailDialog.setTitle("Добавление пользователя");
        emailDialog.setHeaderText("Введите email пользователя");
        emailDialog.setContentText("Email:");
        Optional<String> emailInput = emailDialog.showAndWait();
        if (emailInput.isEmpty()) return;

        try {
            viewModel.addUser(new User(id, nameInput.get(), emailInput.get()));
            updateUserList();
            showInfo("Пользователь добавлен", "Пользователь успешно добавлен.");
        } catch (Exception e) {
            showError("Ошибка добавления", "Не удалось добавить пользователя: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void updateUserList() {
        try {
            userListView.getItems().clear();
            viewModel.getAllUsers().forEach(user -> userListView.getItems().add(
                    String.format("%s (%s)", user.getName(), user.getEmail())
            ));
        } catch (Exception e) {
            showError("Ошибка загрузки пользователей", "Не удалось загрузить список пользователей: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}