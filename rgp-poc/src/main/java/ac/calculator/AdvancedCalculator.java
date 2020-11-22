package ac.calculator;

import ac.math.IMathFunctionality;
import ac.processing.ExpressionTree;
import ac.processing.IParser;
import ac.processing.ITokenizer;
import org.apfloat.Apfloat;
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
    public Apfloat evaluate(String input) {
        try {
            expression = parser.parse(tokenizer.tokenize(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expression.evaluate();

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

    public IMathFunctionality getMathImplementation() {
        return bm;
    }
    
}
