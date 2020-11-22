package ac.processing;

import ac.math.IMathFunctionality;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ASCIITokenizer implements ITokenizer {

    private List<Token> tokens;
    private Set<String> operators;
    private boolean numberMode;
    private StringBuilder buffer;

    public ASCIITokenizer(IMathFunctionality mf) {
        tokens = new ArrayList<>();
        operators = new HashSet<>();
        getAvailableMethods(mf);
        numberMode = true;
        buffer = new StringBuilder();
    }

    @Override
    public List<Token> tokenize(String input) throws Exception {

        String _input = normalize(input);
        for (int i = 0; i < _input.length(); i++) {
            try {
                String digit = _input.substring(i, i + 1);
                Integer.parseInt(digit);
                if (!numberMode) {
                    if (buffer.length() != 0) {
                        var value = buffer.toString();
                        tokens.add(new Token(MathType.OPERATOR, value));
                        buffer.delete(0, buffer.length());
                    }
                    numberMode = true;
                }
                buffer.append(digit);

            } catch (NumberFormatException nfe) {

                var operatorChar = _input.substring(i, i + 1);
                if (numberMode && buffer.length() != 0) {
                    var value = buffer.toString();
                    tokens.add(new Token(MathType.NUMBER, value));
                    buffer.delete(0, buffer.length());
                }
                buffer.append(operatorChar);
                numberMode = false;
            }
        }
        //Determining what type remained in the buffer
        try {
            Integer.parseInt(buffer.toString());
            tokens.add(new Token(MathType.NUMBER, buffer.toString()));
        } catch (NumberFormatException nfe) {
            tokens.add(new Token(MathType.OPERATOR, buffer.toString()));
        }

        return tokens;
    }

    private String normalize(String input) {
        return input.strip().replace(" ", "").toLowerCase();
    }

    private void getAvailableMethods(IMathFunctionality mf) {
        for (Method m : mf.getClass().getMethods())
            operators.add(m.getName());
    }
}
