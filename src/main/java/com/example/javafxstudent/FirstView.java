package com.example.javafxstudent;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstView extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Start");
        Group root = new Group();
        Scene scene = new Scene(root , 500,500);
        Text text = new Text( 70, 50,"Anis Siam");
        text.setFont(new Font("OpenSymbol", 20));
        text.setFill(Color.CRIMSON);
        text.setText("Sami");
        text.setEffect(new DropShadow(10 , Color.BLUE));
     /*   text.setX(100);
        text.setY(100);*/

        root.getChildren().add(text);
        //scene.setFill(Color.CRIMSON);
        stage.setScene(scene);
        stage.setTitle("first java FX");
        //stage.setFullScreen(true);
       // stage.setResizable(false);
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }
}
