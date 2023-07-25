package com.example.javafxstudent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteStudent {
    static Stage deleteStudent(Stage stage1 , Scene prevScene) {
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root , 400,500);
        Text message = new Text();
        Text text = new Text("Delete Student");
        text.setFont(new Font(18));
        root.getChildren().add(text);
        BorderPane borderPane = new BorderPane();
        borderPane.setMaxWidth(300);
        TextField idFiled = Widget.inputField("Please add id");
        borderPane.setLeft(idFiled);

        Button button = new Button("Search");
        borderPane.setRight(button);

        root.getChildren().add(borderPane);

        root.getChildren().add(message);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String id = idFiled.getText();
                if (id.isEmpty()){
                    message.setText("Please enter the id ");
                    return;
                }

                Student student = Panel.showStudent(Integer.valueOf(id));
                if (student==null){
                    message.setText("Not found");
                    return;
                }
                deleteStudentView(student , message);

            }
        });


        stage1.setScene(scene);
        return stage1;
    }

    private static void deleteStudentView(Student student , Text m) {
        m.setText(Panel.deleteStudent(student));
    }


}
