package ac.processing;

import java.util.List;

public class InfixParser implements IParser{
    private ExpressionTree tree;
    private Node currentNode;
    private Node root;

    public InfixParser() {
        tree = new ExpressionTree();
        currentNode = null;
        root = null;
        tree.setRoot(null);
    }

    @Override
    public ExpressionTree parse(List<Token> input) {

        //TODO please implement this

        return tree;
    }
}
