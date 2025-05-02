package huffmantree;

public class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private T val;
    private int frecuency;

    public Node(Node<T> left, Node<T> right, T val, int frecuency){
        this.left = left;
        this.right = right;
        this.val = val;
        this.frecuency = frecuency;
    }
    
    public Node<T> getLeft() {
        return this.left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getVal() {
        return this.val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public int getFrecuency() {
        return this.frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }    

}
