package com.example.javafxstudent;

import javafx.scene.control.TextField;

public class Widget {
    static TextField inputField(String text) {
        TextField input = new TextField();
        input.setPromptText(text);
        input.setMaxWidth(250);
        input.setFocusTraversable(false);
        return input;
    }

}
