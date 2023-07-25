package com.example.javafxstudent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Home extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
        Panel.addDefultData();

    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(menu());
        stage.setTitle("Student panel");
        stage.show();

    }
    private Scene menu(){
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root , 400,500);

        Label label = new Label("1-Add Student\n2-Show Student\n3-Show All Student\n4-Update Student\n" + "5-Delete Student\n6-Order Student by mark\n7-Get all Success student\n8-Exit");
        label.setFont(new Font(20));
        root.getChildren().add(label);
        TextField input =Widget.inputField("Please select option");
        root.getChildren().add(input);

        Text message = new Text();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50);
        Button okButton = new Button("Submit");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (isValid(input , message)){
                    Stage stage1 =(Stage) okButton.getScene().getWindow();
                    String text = input.getText();
                    int option = Integer.parseInt(text);
                    System.out.println(option);
                    Scene scene1 ;
                    switch (option){
                        case 1 :
                            scene1 = AddStudentClass.addStudent(stage1 , scene).getScene();
                            stage1.setScene(scene1);

                            break;
                        case 2 :
                            scene1 = ShowStudent.showStudent(stage1 , scene).getScene();
                            stage1.setScene(scene1);
                            break;

                        case 3 :
                            scene1 = ShowAllStudent.showAllStudent(stage1 , scene).getScene();
                            stage1.setScene(scene1);
                            break;

                        case 5 :
                            scene1 = DeleteStudent.deleteStudent(stage1 , scene).getScene();
                            stage1.setScene(scene1);
                            break;

                    }
                }


            }
        });

        hBox.getChildren().add(okButton);

        Button cancelButton = new Button("Cancel");
        hBox.getChildren().add(cancelButton);

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
        });
        root.getChildren().add(hBox);


        root.getChildren().add(message);
        return scene;
    }

    private boolean isValid(TextField input, Text message) {
        boolean b = true;
        String text = input.getText();
        if (text.isEmpty()){
            message.setText("Please select option");
            message.setFill(Color.RED);
            return false;
        }
        int option = Integer.parseInt(text);
        if (option<=0 || option>8){
            message.setText("Please select valid option");
            message.setFill(Color.RED);
            return false;
        }
        return b;
    }




    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }
}
