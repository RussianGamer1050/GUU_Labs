package ru.guu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class App extends Application {

    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public void start(Stage stage) {
        stage.setTitle("HTTP Request App");

        // Элементы интерфейса
        TextField urlField = new TextField("https://catfact.ninja/fact");
        urlField.setPromptText("Введите API URL");

        ComboBox<String> requestTypeBox = new ComboBox<>();
        requestTypeBox.getItems().addAll("GET", "POST");
        requestTypeBox.setValue("GET");

        TextArea requestBodyArea = new TextArea();
        requestBodyArea.setPromptText("Введите тело POST");
        requestBodyArea.setVisible(false);

        requestTypeBox.setOnAction(e -> 
            requestBodyArea.setVisible("POST".equals(requestTypeBox.getValue()))
        );

        Button sendRequestButton = new Button("Отправить запрос");
        TextArea responseArea = new TextArea();
        responseArea.setEditable(false);

        // Логика нажатия на кнопку
        sendRequestButton.setOnAction(e -> {
            String url = urlField.getText();
            String requestType = requestTypeBox.getValue();
            String requestBody = requestBodyArea.getText();

            try {
                String response = sendHttpRequest(url, requestType, requestBody);
                responseArea.setText(response);
            } catch (Exception ex) {
                responseArea.setText("Ошибка: " + ex.getMessage());
            }
        });

        VBox root = new VBox(10, urlField, requestTypeBox, requestBodyArea, sendRequestButton, responseArea);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 600, 500);

        // CSS стиль
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    // Метод отправки запроса
    private String sendHttpRequest(String url, String method, String body) throws IOException {
        Request request;

        if ("POST".equalsIgnoreCase(method)) {
            RequestBody requestBody = RequestBody.create(body, MediaType.parse("application/json"));
            request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
        } else {
            request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
        }

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body() != null ? response.body().string() : "Нет тела запроса";
            } else {
                throw new IOException("HTTP error code: " + response.code());
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
