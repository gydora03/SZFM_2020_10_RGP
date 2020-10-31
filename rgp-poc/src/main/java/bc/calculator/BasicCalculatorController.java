package bc.calculator;

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

import java.io.IOException;

public class BasicCalculatorController {

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
    private Button clear;

    @FXML
    private Button allClear;

    @FXML
    private Button addition;

    @FXML
    private Button subtraction;

    @FXML
    private Button multiplication;

    @FXML
    private Button division;

    @FXML
    private Button percentage;

    @FXML
    private Button sinus;

    @FXML
    private Button cosinus;

    @FXML
    private Button tangens;

    @FXML
    private Button cotangens;

    @FXML
    private Button modulo;

    @FXML
    private Button xPowY;

    @FXML
    private Button squareRoot;

    @FXML
    private Button greatestCommonDivisor;

    @FXML
    private Button leastCommonMultiple;

    @FXML
    private Button factorial;

    @FXML
    private Button equal;

    @FXML
    private Button zero;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button decimalDot;

    @FXML
    private Button plusMinus;

    @FXML
    private Button memoryOne;

    @FXML
    private Button memoryTwo;

    @FXML
    private Button memoryThree;

    @FXML
    private Button memoryFour;

    @FXML
    private MenuItem closeMenuItem;

    private BasicCalculator basicCalculator;
    private String memory_one = "";
    private String memory_two = "";
    private String memory_three = "";
    private String memory_four = "";

    private boolean isOperatorClicked = false;

    @FXML
    MenuBar menuBar;

    public BasicCalculatorController()
    {
        basicCalculator = new BasicCalculator(new BasicMath());
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
    public void handleClickOnCloseMenuItem(ActionEvent event) {
        Platform.exit();
        System.exit(0);
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
