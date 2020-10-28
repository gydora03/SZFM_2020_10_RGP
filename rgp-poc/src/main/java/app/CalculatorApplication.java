package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {

        Parent parent = FXMLLoader.load(CalculatorApplication.class.getResource("/fxml/basicCalculator.fxml"));
        stage.setTitle("Basic Calculator");
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
