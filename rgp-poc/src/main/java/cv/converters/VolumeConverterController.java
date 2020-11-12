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

public class VolumeConverterController {

    @FXML
    MenuBar menuBar;

    @FXML
    MenuButton fromMenuButton;

    @FXML
    MenuButton toMenuButton;

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
    public double convertUnitToLiter(String unitName, double literUnit) {

        switch (unitName) {
            case "Milliliter":
                literUnit = literUnit/1000;
                break;
            case "Centiliter":
                literUnit = literUnit/100;
                break;
            case "Deciliter":
                literUnit = literUnit/10;
                break;
            case "Decaliter":
                literUnit = literUnit*10;
                break;
            case "Hectoliter":
                literUnit = literUnit*100;
                break;
            case "Kiloliter":
                literUnit = literUnit*1000;
                break;
            case "Cups":
                literUnit = literUnit*0.2365882365;
                break;
            case "Teaspoons":
                literUnit = literUnit*0.0049289216;
                break;
            case "Gallon":
                literUnit = literUnit*3.785411784;
                break;
        }
        return literUnit;
    }

    @FXML
    public double convertToTargetUnit(String unitName, double targetUnit) {

        switch (unitName) {
            case "Milliliter":
                targetUnit = targetUnit*1000;
                break;
            case "Centiliter":
                targetUnit = targetUnit*100;
                break;
            case "Deciliter":
                targetUnit = targetUnit*10;
                break;
            case "Decaliter":
                targetUnit = targetUnit/10;
                break;
            case "Hectoliter":
                targetUnit = targetUnit/100;
                break;
            case "Kiloliter":
                targetUnit = targetUnit/1000;
                break;
            case "Cups":
                targetUnit = targetUnit*4.2267528377;
                break;
            case "Teaspoons":
                targetUnit = targetUnit*202.88413621;
                break;
            case "Gallon":
                targetUnit = targetUnit*0.2641720524;
                break;
        }

        return targetUnit;
    }

    @FXML
    public void handleClickOnConvertButton(ActionEvent event) {
        String unitFromName = unitFrom.toString();
        double unitFrom = Double.parseDouble(displayFrom.toString());
        double inLiter = convertUnitToLiter(unitFromName, unitFrom);

        String unitToName = unitTo.toString();
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
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("PI Calculator");
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
    public void switchToTemperatureConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/temperatureConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }


}
