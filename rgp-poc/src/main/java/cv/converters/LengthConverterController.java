package cv.converters;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LengthConverterController {

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
        unitFrom.setText(menuItemText.toLowerCase());
    }

    @FXML
    public void selectMenuItemFromToMenuButton(ActionEvent event) {

        String menuItemText = ((MenuItem) event.getSource()).getText();
        unitTo.setText(menuItemText.toLowerCase());
    }

    @FXML
    public double convertUnitToMeter(String unitName, double meterUnit) {

        switch (unitName) {
            case "millimeter":
                meterUnit = meterUnit/1000;
                break;
            case "centimeter":
                meterUnit = meterUnit/100;
                break;
            case "decimeter":
                meterUnit = meterUnit/10;
                break;
            case "decameter":
                meterUnit = meterUnit*10;
                break;
            case "hectometer":
                meterUnit = meterUnit*100;
                break;
            case "kilometer":
                meterUnit = meterUnit*1000;
                break;
            case "inch":
                meterUnit = meterUnit*0.0254;
                break;
            case "feet":
                meterUnit = meterUnit*0.3048;
                break;
            case "yard":
                meterUnit = meterUnit*0.9144;
                break;
        }
        return meterUnit;
    }

    @FXML
    public double convertToTargetUnit(String unitName, double targetUnit) {

        switch (unitName) {
            case "millimeter":
                targetUnit = targetUnit*1000;
                break;
            case "centimeter":
                targetUnit = targetUnit*100;
                break;
            case "decimeter":
                targetUnit = targetUnit*10;
                break;
            case "decalmeter":
                targetUnit = targetUnit/10;
                break;
            case "hectometer":
                targetUnit = targetUnit/100;
                break;
            case "kilometer":
                targetUnit = targetUnit/1000;
                break;
            case "inch":
                targetUnit = targetUnit*39.37007874;
                break;
            case "feet":
                targetUnit = targetUnit*3.280839895;
                break;
            case "yard":
                targetUnit = targetUnit*1.0936132983;
                break;
        }
        return targetUnit;
    }

    @FXML
    public void handleClickOnConvertButton(ActionEvent event) {
        String unitFromName = unitFrom.getText();
        double unitFrom = Double.parseDouble(displayFrom.getText());
        double inLiter = convertUnitToMeter(unitFromName, unitFrom);

        String unitToName = unitTo.getText();
        double unitTo = convertToTargetUnit(unitToName, inLiter);

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
    public void switchToWeightConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/weightConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Weight Converter");
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
