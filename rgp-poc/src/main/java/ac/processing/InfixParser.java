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

        ExpressionTree etree = new ExpressionTree();

        //Rules of engagement
        //1. Number: left child, if not full, then right
        //2. Operator:
        //same or lower precedence: root = new temp().left(root)
        //higher precedence: root.right(new node)

        for(int i=0; i<input.size(); i++) {

        }

        return tree;
    }
}
