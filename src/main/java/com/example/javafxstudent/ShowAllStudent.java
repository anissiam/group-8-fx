package com.example.javafxstudent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShowAllStudent {
    static Stage showAllStudent(Stage stage1 , Scene prevScene) {
        Group root = new Group();
        Scene scene = new Scene(root , 400,500);
        Text message = new Text();
        Text text = new Text("Show all Student");
        text.setLayoutX(150);
        text.setLayoutY(20);
        text.setFont(new Font(18));
        root.getChildren().add(text);

        Button button = new Button("Back");
        button.setLayoutX(20);
        button.setLayoutY(20);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage1.setScene(prevScene);
            }
        });
        root.getChildren().add(button);

        ListView listView = new ListView();
        listView.setPrefWidth(400);
        listView.setLayoutY(50);
        if (!Panel.getAllStudent().isEmpty()){
            listView.getItems().addAll(Panel.getAllStudent());
        }
        root.getChildren().add(listView);

        stage1.setScene(scene);
        return stage1;
    }



    /*ListView listView = new ListView();
        listView.getItems().addAll(addDefultData());

        root.getChildren().add(listView);*/
}
