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
            case "milliliter":
                literUnit = literUnit/1000;
                break;
            case "centiliter":
                literUnit = literUnit/100;
                break;
            case "deciliter":
                literUnit = literUnit/10;
                break;
            case "decaliter":
                literUnit = literUnit*10;
                break;
            case "hectoliter":
                literUnit = literUnit*100;
                break;
            case "kiloliter":
                literUnit = literUnit*1000;
                break;
            case "cubic meter":
                literUnit = literUnit*1000;
                break;
            case "cubic centimeter":
                literUnit = literUnit/1000;
                break;
            case "cups":
                literUnit = literUnit*0.2365882365;
                break;
            case "teaspoons":
                literUnit = literUnit*0.0049289216;
                break;
            case "gallon":
                literUnit = literUnit*3.785411784;
                break;
        }
        return literUnit;
    }

    @FXML
    public double convertToTargetUnit(String unitName, double targetUnit) {

        switch (unitName) {
            case "milliliter":
                targetUnit = targetUnit*1000;
                break;
            case "centiliter":
                targetUnit = targetUnit*100;
                break;
            case "deciliter":
                targetUnit = targetUnit*10;
                break;
            case "decaliter":
                targetUnit = targetUnit/10;
                break;
            case "hectoliter":
                targetUnit = targetUnit/100;
                break;
            case "kiloliter":
                targetUnit = targetUnit/1000;
                break;
            case "cubic meter":
                targetUnit = targetUnit/1000;
                break;
            case "cubic centimeter":
                targetUnit = targetUnit*1000;
                break;
            case "cups":
                targetUnit = targetUnit*4.2267528377;
                break;
            case "teaspoons":
                targetUnit = targetUnit*202.88413621;
                break;
            case "gallon":
                targetUnit = targetUnit*0.2641720524;
                break;
        }
        return targetUnit;
    }

    @FXML
    public void handleClickOnConvertButton(ActionEvent event) {
        String unitFromName = unitFrom.getText();
        double unitFrom = Double.parseDouble(displayFrom.getText());
        double inLiter = convertUnitToLiter(unitFromName, unitFrom);

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
