package bc.calculator;

import org.tinylog.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasicCalculator implements ICalculator<Double> {

    private Calculation storedCalculation;
    private IBasicMathFunctionality bm;
    private HashMap<String, IModule> modules;
    private HashMap<String, Method> functions;

    public BasicCalculator(IBasicMathFunctionality bm) {
        modules = new HashMap<>();
        functions = new HashMap<>();
        this.bm = bm;

        for (Method m : bm.getClass().getMethods()) {
            functions.put(m.getName(), m);
        }

        registerModule("history", HistoryModule.getInstance());

        Logger.tag("BasicCalculator").debug("Constructor has been executed successfully");

    }


    @Override
    public Double evaluate(Calculation calculation) {
        if (storedCalculation == null || storedCalculation.getCurrentOperator().equals("=")) {
            storedCalculation = calculation;
            this.<HistoryModule>getModule("history").logCalculation(storedCalculation);
            Method m = getMathMethod(storedCalculation);
            if (m == null)
                return storedCalculation.getCurrentValue();
            try {
                if (m.getParameterCount() == 1) {
                    storedCalculation.setCurrentOperator(calculation.getCurrentOperator());
                    storedCalculation.setCurrentValue((Double) m.invoke(bm, storedCalculation.getCurrentValue()));
                    this.<HistoryModule>getModule("history").logCalculation(storedCalculation);
                    return storedCalculation.getCurrentValue();
                } else
                    return storedCalculation.getCurrentValue();
            } catch (InvocationTargetException | IllegalAccessException iae) {
                System.out.println(iae.getMessage());
            }
        }

        Method method = getMathMethod(calculation);
        if (method == null)
            return storedCalculation.getCurrentValue();
        try {
            if (method.getParameterCount() == 1)
                storedCalculation.setCurrentValue((Double) method.invoke(bm, storedCalculation.getCurrentValue()));
            else
                storedCalculation.setCurrentValue((Double) method.invoke(bm, storedCalculation.getCurrentValue(), calculation.getCurrentValue()));
            storedCalculation.setCurrentOperator(calculation.getCurrentOperator());
            this.<HistoryModule>getModule("history").logCalculation(storedCalculation);
            return storedCalculation.getCurrentValue();

        } catch (InvocationTargetException | IllegalAccessException iae) {
            System.out.println(iae.getMessage());
            Logger.tag("BasicCalculator").error("{} has happened!! Check stacktrace for further information.", iae.getClass().getName());
            Logger.tag("BasicCalculator").error(iae.getMessage());
        }
        return Double.NaN;

    }

    private Method getMathMethod(Calculation calculation) {
        Method method = null;

        if (calculation.getCurrentOperator().equals("=")) {
            if (storedCalculation.getCurrentOperator().equals("="))
                storedCalculation.setCurrentValue(calculation.getCurrentValue());
            else
                method = functions.get(storedCalculation.getCurrentOperator());
        } else if (storedCalculation.getCurrentOperator().equals("=")) {
            method = functions.get(calculation.getCurrentOperator());
        } else {
            Method newMethod = functions.get(calculation.getCurrentOperator());
            Method oldMethod = functions.get(storedCalculation.getCurrentOperator());
            if (newMethod.getParameterCount() == 1 && oldMethod.getParameterCount() == 2)
                method = newMethod;
            else
                method = functions.get(storedCalculation.getCurrentOperator());
        }


        return method;
    }

    public void registerModule(String moduleName, IModule m) {

        modules.put(moduleName, m);

    }

    public <T extends IModule> T getModule(String moduleName) {
        if (modules.containsKey(moduleName))
            return (T) modules.get(moduleName);
        else
            return null;
    }

    public void clearCalculations() {
        storedCalculation = null;
    }

    public void updateOperator(String operator) {
        if (storedCalculation != null)
            storedCalculation.setCurrentOperator(operator);
    }
}