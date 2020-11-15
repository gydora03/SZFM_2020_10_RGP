package ac.processing;

import org.apfloat.Apfloat;

public class ExpressionTree {
    private Node root;

    public ExpressionTree() {
        root = null;
    }

    public void setRoot(Node n) {
        root = n;
    }

    public Node getRoot() {
        return root;
    }

    public Apfloat evaluate() {
        return Apfloat.ZERO;
    }
}
