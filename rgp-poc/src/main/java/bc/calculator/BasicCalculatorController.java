package bc.calculator;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import app.CalculatorApplication;

import java.io.IOException;

public class BasicCalculatorController {

    @FXML
    public void handleClickOnCloseMenuItem(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void switchToAdvancedCalculator(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/advancedCalculator.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Advanced Calculator");
        stage.setScene(scene);
        stage.show();
        CalculatorApplication.stage.getScene().setRoot(parent);
    }

    @FXML
    public void switchToPICalculator(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/piCalculator.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("PI Calculator");
        stage.setScene(scene);
        stage.show();
        CalculatorApplication.stage.getScene().setRoot(parent);
    }

    @FXML
    public void switchToVolumeConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/volumeConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Volume Converter");
        stage.setScene(scene);
        stage.show();
        CalculatorApplication.stage.getScene().setRoot(parent);
    }

    @FXML
    public void switchToLengthConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/lengthConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Length Converter");
        stage.setScene(scene);
        stage.show();
        CalculatorApplication.stage.getScene().setRoot(parent);
    }

    @FXML
    public void switchToWeightConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/weightConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Weight Converter");
        stage.setScene(scene);
        stage.show();
        CalculatorApplication.stage.getScene().setRoot(parent);
    }


}
