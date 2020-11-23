package ac.calculator;


import ac.math.ConstantProvider;
import ac.module.HistoryModule;
import ac.providers.AdvancedMath;
import ac.providers.Calculation;
import ac.providers.ConstantProvider;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class AdvancedCalculatorController {

    @FXML
    private MenuItem piMenuItem;

    @FXML
    private MenuItem eulerMenuItem;

    @FXML
    private MenuItem BernsteinMenuItem;

    @FXML
    private MenuItem goldenRatioMenuItem;

    @FXML
    private TextField display;

    @FXML
    private Button memoryOne;

    @FXML
    private Button memoryTwo;

    @FXML
    private Button memoryThree;

    @FXML
    private Button memoryFour;

    @FXML
    private AdvancedCalculator basicCalculator;
    private String memory_one = "";
    private String memory_two = "";
    private String memory_three = "";
    private String memory_four = "";

    private boolean isOperatorClicked = false;

    @FXML
    MenuBar menuBar;

    public AdvancedCalculatorController()
    {
        basicCalculator = new AdvancedCalculator(new AdvancedMath());
    }
    @FXML
    public void handleClickOnOperator(ActionEvent event) {
        Logger.info("Operator was clicked");
        Calculation calc = new Calculation();
        double value = Double.parseDouble(display.getText());
        calc.setCurrentValue(Double.valueOf(value));

        String operator = ((Button) event.getSource()).getText();
        switch (operator) {
            case "+":
                calc.setCurrentOperator("add");
                break;
            case "-":
                calc.setCurrentOperator("subtract");
                break;
            case "X":
                calc.setCurrentOperator("multiply");
                break;
            case "/":
                calc.setCurrentOperator("divide");
                break;
            case "%":
                calc.setCurrentOperator("mod");
                break;
            case "sin":
            case "cos":
            case "tan":
            case "ctg":
                isOperatorClicked = false;
                calc.setCurrentOperator(operator);
                break;
            case "x^y":
                calc.setCurrentOperator("power");
                break;
            case "sqrt(x)":
                isOperatorClicked = false;
                calc.setCurrentOperator("sqrt");
                break;
            case "x!":
                isOperatorClicked = false;
                calc.setCurrentOperator("factorial");
                break;
            case "gcd":
            case "lcm":
                calc.setCurrentOperator(operator);
                break;
            case "=":
                calc.setCurrentOperator("=");
                break;
            default:
                calc.setCurrentOperator("=");
                break;

        }

        if(!isOperatorClicked) {
            String result = String.valueOf(basicCalculator.evaluate(calc));
            Logger.tag("BasicCalculator").debug("Evaluating Calculation...");
            Logger.tag("BasicCalculator").debug("Permorming: {}", calc.getCurrentOperator() + " " + calc.getCurrentValue());
            Logger.tag("BasicCalculator").debug("Evaluation has been completed, result is {}", result);
            display.setText(result);
        }
        else {
            basicCalculator.updateOperator(calc.getCurrentOperator());
            return;
        }
        isOperatorClicked = true;

    }

    @FXML
    private void handleClickOnNumber(ActionEvent event) {

        if(isOperatorClicked)
            display.setText("");
        isOperatorClicked = false;

        String digit = ((Button) event.getSource()).getText();
        if(digit.equals(".") && display.getText().contains("."))
            return;
        display.setText(display.getText().concat(digit));
    }
    @FXML
    private void handleClickOnClear() {
        display.setText("");
    }

    @FXML
    private void handleClickOnAllClear() {
        basicCalculator.clearCalculations();
        display.clear();
        memory_one = "";
        memory_two = "";
        memory_three = "";
        memory_four = "";
    }


    @FXML
    private void handleClickOnPlusMinusSign(ActionEvent event) {
        double displayText = Double.parseDouble(display.getText());
        displayText = displayText * (-1);
        display.setText(String.valueOf(displayText));
    }


    @FXML
    private void handleClickOnMemory(ActionEvent event) {
        if (event.getSource() == memoryOne) {
            Logger.tag("BasicCalculatorController").debug("Memory button {} was clicked", 1);
            if (memory_one.equals("")) {
                memory_one = display.getText();
            } else {
                display.setText(memory_one);
            }
        }
        if (event.getSource() == memoryTwo) {
            Logger.tag("BasicCalculatorController").debug("Memory button {} was clicked", 2);
            if (memory_two.equals("")) {
                memory_two = display.getText();
            } else {
                display.setText(memory_two);
            }
        }
        if (event.getSource() == memoryThree) {
            Logger.tag("BasicCalculatorController").debug("Memory button {} was clicked", 3);
            if (memory_three.equals("")) {
                memory_three = display.getText();
            } else {
                display.setText(memory_three);
            }
        }
        if (event.getSource() == memoryFour) {
            Logger.tag("BasicCalculatorController").debug("Memory button {} was clicked", 4);
            if (memory_four.equals("")) {
                memory_four = display.getText();
            } else {
                display.setText(memory_four);
            }
        }
    }
    @FXML
    private void handleClickOnConstant(ActionEvent event){
        isOperatorClicked = false;

        if(event.getSource() == piMenuItem){
            Logger.tag("BasicCalculatorController").info("Constant PI was clicked");
            display.setText(String.valueOf(ConstantProvider.getPi()));
        }
        else if(event.getSource() == eulerMenuItem){
            Logger.tag("BasicCalculatorController").info("Constant Euler was clicked");
            display.setText(String.valueOf(ConstantProvider.getEulerConstant()));
        }
        else if(event.getSource() == BernsteinMenuItem){
            Logger.tag("BasicCalculatorController").info("Constant Bernstein was clicked");
            display.setText(String.valueOf(ConstantProvider.getBernsteinConstant()));
        }
        else if(event.getSource() == goldenRatioMenuItem){
            Logger.tag("BasicCalculatorController").info("Constant GoldenRatio was clicked");
            display.setText(String.valueOf(ConstantProvider.getGoldenRatio()));
        }
    }
    public void handleHistoryButton(ActionEvent actionEvent) {
        HistoryModule hm = basicCalculator.<HistoryModule>getModule("history");
        if(hm != null){
            hm.dumpLogs();
            display.setText("History was saved to historyLogs.txt!");
        }
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
