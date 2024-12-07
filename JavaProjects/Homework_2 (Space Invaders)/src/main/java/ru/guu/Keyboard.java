package ru.guu;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Keyboard {

    private static Map<KeyCode, Boolean> keys = new HashMap<>();

    public static void initialize(Scene scene) {
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
    }

    public static boolean isKeyPressed(KeyCode code) {
        return keys.getOrDefault(code, false);
    }
}