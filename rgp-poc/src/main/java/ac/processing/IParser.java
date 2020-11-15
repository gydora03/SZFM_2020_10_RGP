package ac.processing;

import java.util.List;

public interface IParser {

    public ExpressionTree parse(List<Token> input);
}
