package com.example.javafxstudent;

import javafx.collections.FXCollections;
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

import java.time.Year;

public class AddStudentClass {
    String gender = "male";

     static Stage addStudent(Stage stage1 , Scene prevScene) {
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(20);
        Scene scene = new Scene(root , 400,500);
        Text message = new Text();
        Text text = new Text("Add Student");
        text.setFont(new Font(18));
        root.getChildren().add(text);
        TextField idFiled = Widget.inputField("Please add id");
        root.getChildren().add(idFiled);

         TextField nameFeild = Widget.inputField("Please add name");
        root.getChildren().add(nameFeild);

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Date of birth");
        datePicker.setFocusTraversable(false);
        root.getChildren().add(datePicker);

        HBox hBox = new HBox();
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setSelected(true);
        maleRadio.setToggleGroup(toggleGroup);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(toggleGroup);

        hBox.getChildren().addAll(maleRadio, femaleRadio);
        root.getChildren().add(hBox);

        TextField markFiled = Widget.inputField("Please Add Mark");
        root.getChildren().add(markFiled);


        ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "CS","AI","Eng."
        ));

        choiceBox.setValue("CS");
        root.getChildren().add(choiceBox);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(50);
        Button okButton = new Button("Submit");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                /*Stage stage1 =(Stage) okButton.getScene().getWindow();
                addStudent(stage1);*/
                if (idFiled.getText().isEmpty()){
                    message.setText("Please add Id");
                    message.setFill(Color.RED);
                    return;
                }

                if (nameFeild.getText().isEmpty()){
                    message.setText("Please add name");
                    message.setFill(Color.RED);
                    return;
                }

                if (datePicker.getValue() == null){
                    message.setText("Please select DOB");
                    message.setFill(Color.RED);
                    return;
                }

                if (markFiled.getText().isEmpty()){
                    message.setText("Please add mark");
                    message.setFill(Color.RED);
                    return;
                }

                if (choiceBox.getValue()==null){
                    message.setText("Please select major");
                    message.setFill(Color.RED);
                    return;
                }
                int id = Integer.valueOf(idFiled.getText());


                int date = datePicker.getValue().getYear();

                int y = Year.now().getValue();
                int age = y - date;

                RadioButton  selected= (RadioButton) toggleGroup.getSelectedToggle();

                byte mark = Byte.valueOf(markFiled.getText());
                Student student = new Student( id , nameFeild.getText() ,(byte) age
                        ,selected.getText(),mark , choiceBox.getValue().toString()  );
                Panel.addStudent(student);

                message.setText("Added");
                message.setFill(Color.BLACK);




            }
        });

        hBox1.getChildren().add(okButton);

        Button cancelButton = new Button("Back");
        hBox1.getChildren().add(cancelButton);

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage1.setScene(prevScene);

            }
        });
        root.getChildren().add(hBox1);
        root.getChildren().add(message);
        stage1.setScene(scene);

        return stage1;
    }

/*
//Get Age
                int date = datePicker.getValue().getYear();
                Calendar calendar = Calendar.getInstance();

                int y = Year.now().getValue();
                System.out.println(date);
                System.out.println(y);
                System.out.println(y - date);
 */
}
