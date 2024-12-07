package ru.guu;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Inject
    DiscountService discountService;

    @Override
    public void init() {
        Injector injector = Guice.createInjector(new AppModule());
        injector.injectMembers(this);
    }

    @Override
    public void start(Stage stage) {

        TextField productNameField = new TextField();
        productNameField.setPromptText("Наименование");

        TextField productCostField = new TextField();
        productCostField.setPromptText("Цена");

        ComboBox<String> discountTypeComboBox = new ComboBox<>();
        discountTypeComboBox.getItems().addAll("Без скидки", "Проц. скидка", "Фикс. скидка");
        discountTypeComboBox.setPromptText("Выберите тип скидки");

        Button calculateButton = new Button("Расчитать");
        Label resultLabel = new Label();

        calculateButton.setOnAction(event -> {
            String productName = productNameField.getText();
            String productCostText = productCostField.getText();
            String discountType = discountTypeComboBox.getValue();

            try {
                double productCost = Double.parseDouble(productCostText);
                double finalCost = discountService.calculateCost(productCost, discountType);
                resultLabel.setText("Конечная цена: " + productName + ": руб. " + finalCost);
            } catch (NumberFormatException e) {
                resultLabel.setText("Пожалуйста введите корректную цену.");
            }
        });

        VBox root = new VBox(10, productNameField, productCostField, discountTypeComboBox, calculateButton, resultLabel);
        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("Product Cost Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
