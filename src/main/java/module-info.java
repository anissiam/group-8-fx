module com.example.javafxstudent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxstudent to javafx.fxml;
    exports com.example.javafxstudent;
}