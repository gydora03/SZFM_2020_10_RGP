package ac.processing;

public class Node {
    private final String data;
    private Node leftChild, rightChild;

    public Node(String data) {
        this.data = data;
    }

    public void setLeftChild(Node n) {
        leftChild = n;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setRightChild(Node n) {
        rightChild = n;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public String getData() {
        return data;
    }
}
