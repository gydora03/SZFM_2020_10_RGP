package providers;
import org.tinylog.Logger;
public class Calculation {
    private Double currentValue;

    private String currentOperator;

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
    }

    public String getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(String currentOperator) {
        this.currentOperator = currentOperator;
    }

}
