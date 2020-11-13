package cv.converters;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WeightConverterController {

    @FXML
    MenuBar menuBar;

    @FXML
    public void handleClickOnCloseMenuItem(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    TextField unitFrom;

    @FXML
    TextField unitTo;

    @FXML
    TextField displayFrom;

    @FXML
    TextField displayTo;

    @FXML
    public void selectMenuItemFromFromMenuButton(ActionEvent event) {

        String menuItemText = ((MenuItem) event.getSource()).getText();
        unitFrom.setText(menuItemText.toLowerCase());
    }

    @FXML
    public void selectMenuItemFromToMenuButton(ActionEvent event) {

        String menuItemText = ((MenuItem) event.getSource()).getText();
        unitTo.setText(menuItemText.toLowerCase());
    }

    @FXML
    public double convertUnitToGram(String unitName, double gramUnit) {

        switch (unitName) {
            case "milligram":
                gramUnit = gramUnit/1000;
                break;
            case "centigram":
                gramUnit = gramUnit/100;
                break;
            case "decigram":
                gramUnit = gramUnit/10;
                break;
            case "decagram":
                gramUnit = gramUnit*10;
                break;
            case "hectogram":
                gramUnit = gramUnit*100;
                break;
            case "kilogram":
                gramUnit = gramUnit*1000;
                break;
            case "pounds":
                gramUnit = gramUnit*453.59;
                break;
        }
        return gramUnit;
    }

    @FXML
    public double convertToTargetUnit(String unitName, double targetUnit) {

        switch (unitName) {
            case "milligram":
                targetUnit = targetUnit*1000;
                break;
            case "centigram":
                targetUnit = targetUnit*100;
                break;
            case "decigram":
                targetUnit = targetUnit*10;
                break;
            case "decagram":
                targetUnit = targetUnit/10;
                break;
            case "hectogram":
                targetUnit = targetUnit/100;
                break;
            case "kilogram":
                targetUnit = targetUnit/1000;
                break;
            case "pounds":
                targetUnit = targetUnit/453.59;
                break;
        }
        return targetUnit;
    }

    @FXML
    public void switchToBasicCalculator(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/basicCalculator.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Basic Calculator");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAdvancedCalculator(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/advancedCalculator.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Advanced Calculator");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToPICalculator(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/piCalculator.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("PI Calculator");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToVolumeConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/volumeConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Volume Converter");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToLengthConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/lengthConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Length Converter");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTemperatureConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/temperatureConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

}
