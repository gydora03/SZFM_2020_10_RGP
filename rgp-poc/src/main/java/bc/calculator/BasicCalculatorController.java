package calculator;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import module.HistoryModule;
import org.tinylog.Logger;
import providers.BasicMath;
import providers.Calculation;
import providers.ConstantProvider;

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
/*
    @FXML
    public void PiMenuItem(ActionEvent e){
        System.out.println("asd");
    }*/



    @FXML
    private void handleClickOnCloseMenuItem(ActionEvent event) {
        Logger.tag("SYSTEM").debug("Terminating application.");
        Platform.exit();
        System.exit(0);

    }

    public void handleHistoryButton(ActionEvent actionEvent) {
        HistoryModule hm = basicCalculator.<HistoryModule>getModule("history");
        if(hm != null){
            hm.dumpLogs();
            display.setText("History was saved to historyLogs.txt!");
        }
    }
}