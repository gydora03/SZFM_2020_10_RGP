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


public class TemperatureConverterController {

    @FXML
    MenuBar menuBar;

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
        unitFrom.setText(menuItemText);
    }

    @FXML
    public void selectMenuItemFromToMenuButton(ActionEvent event) {

        String menuItemText = ((MenuItem) event.getSource()).getText();
        unitTo.setText(menuItemText);
    }

    @FXML
    public double convertUnitToCelsius(String unitName, double celsiusUnit) {

        switch (unitName) {
            case "kelvin":
                celsiusUnit = celsiusUnit-273.15;
                break;
            case "fahrenheit":
                celsiusUnit = (celsiusUnit-32)*5/9;
                break;
        }
        return celsiusUnit;
    }

    @FXML
    public double convertToTargetUnit(String unitName, double targetUnit) {

        switch (unitName) {
            case "kelvin":
                targetUnit = targetUnit+273.15;
                break;
            case "fahrenheit":
                targetUnit = targetUnit*9/5+32;
                break;

        }
        return targetUnit;
    }

    @FXML
    public void handleClickOnConvertButton(ActionEvent event) {
        String unitFromName = unitFrom.getText();
        double unitFrom = Double.parseDouble(displayFrom.getText());
        double inCelsius = convertUnitToCelsius(unitFromName, unitFrom);

        String unitToName = unitTo.getText();
        double unitTo = convertToTargetUnit(unitToName, inCelsius);

        displayTo.setText(String.valueOf(unitTo));
    }

    @FXML
    public void handleClickOnCloseMenuItem(ActionEvent event) {
        Platform.exit();
        System.exit(0);
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
        Stage stage = (Stage)  menuBar.getScene().getWindow();
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
    public void switchToWeightConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/weightConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Weight Converter");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTextConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/textConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Text Converter");
        stage.setScene(scene);
        stage.show();
    }

}
