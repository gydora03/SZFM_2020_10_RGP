package pi.approximators;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PICalculatorController {

    @FXML
    Button calcBtn;
    @FXML
    TextArea screen;
    @FXML
    TextField iterationTb;
    @FXML
    TextField fromTb;
    @FXML
    TextField untilTb;
    @FXML
    ComboBox<String> methodCb;
    @FXML
    MenuBar menuBar;

    private int iteration, from, until;

    private IApproximator piApproximator;


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
    public void switchToTemperatureConverter(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/temperatureConverter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private void clearFields() {
        iterationTb.setText("0");
        fromTb.setText("0");
        untilTb.setText("0");
        methodCb.getSelectionModel().clearSelection();
    }

    private boolean validateFields() {
        boolean isValid = true;

        try {
            iteration = Integer.parseInt(iterationTb.getText());
            from = Integer.parseInt(fromTb.getText());
            until = Integer.parseInt(untilTb.getText());
        } catch (NumberFormatException nfe) {
            isValid = false;
        }

        return isValid;
    }

    @FXML
    public void handleCalculation(ActionEvent actionEvent) {
        if (!validateFields()) {
            clearFields();
            calcBtn.setDisable(true);
            return;
        }

        screen.setText(String.format("A PI megközelítése %s módszer alapján, %d értékű pontossággal!\nLegyen türelemmel!"
                , piApproximator.getClass().getSimpleName(), iteration));
        ((Button) actionEvent.getSource()).setDisable(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (from == 0 && until == 0)
                    screen.setText(piApproximator.approximate(iteration));
                else
                    screen.setText(piApproximator.approximate(iteration, from, until));
                calcBtn.setDisable(false);
            }
        }).start();

    }

    @FXML
    public void handleCb(ActionEvent actionEvent) {
        switch (methodCb.getSelectionModel().getSelectedItem()) {
            case "Chudnovsky":
                piApproximator = new ChudnovskyApproximator();
                fromTb.setDisable(true);
                untilTb.setDisable(true);
                break;
            case "Zeta":
                piApproximator = new ZetaApproximator();
                fromTb.setDisable(true);
                untilTb.setDisable(true);
                break;
            case "Leibniz":
                piApproximator = new LeibnizApproximator();
                fromTb.setDisable(true);
                untilTb.setDisable(true);
                break;
            case "BPP":
                piApproximator = new BPP();
                fromTb.setDisable(false);
                untilTb.setDisable(false);
                break;

            default:
                clearFields();
                calcBtn.setDisable(true);
                return;
        }

        calcBtn.setDisable(false);

    }
}
