package ac.calculator;

import org.tinylog.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class AdvancedCalculator implements ICalculator<Apfloat> {

    private IMathFunctionality bm;
    private ExpressionTree expression;
    private IParser parser;
    private ITokenizer tokenizer;

    public AdvancedCalculator(IMathFunctionality bm) {
        this.bm = bm;

        Logger.tag("AdvancedCalculator").debug("Constructor has been executed successfully");

    }


    @Override
    public Apfloat evaluate() {
        
        return Apfloat.ZERO;

    }
    
    public void registerParser(IParser parser) {
        this.parser = parser;
    }
    
    public void registerTokenizer(ITokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }
    
    public void clearCalculations() {
        this.expression = null;
    }
    
}
