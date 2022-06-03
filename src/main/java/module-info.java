module com.example.lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.lublin.wsei.java.cwiczenia to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia;
    exports pl.lublin.wsei.java.cwiczenia.test;
    opens pl.lublin.wsei.java.cwiczenia.test to javafx.fxml;
}