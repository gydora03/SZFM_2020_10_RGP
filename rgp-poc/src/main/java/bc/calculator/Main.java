package calculator;

import javafx.application.Application;
import org.tinylog.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.tag("SYSTEM").trace("Executing main");
        Application.launch(BasicCalculatorApplication.class, args);
    }
}
