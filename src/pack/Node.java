package pack;

public class Node<E> {
    protected E value; // can only be accessed to child classes.

    public Node() {

    }

    public Node(E value) {
        this.value = value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }
}