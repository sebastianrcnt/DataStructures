package pack;

public class TreeNode<E> extends Node<E> {
  private Node<E> left;
  private Node<E> right;

  public TreeNode() {
    super();
  }

  public TreeNode(E value) {
    super(value);
  }

  public void setLeft(Node<E> left) {
    this.left = left;
  }

  public void setRight(Node<E> right) {
    this.right = right;
  }

  public Node<E> getLeft() {
    return left;
  }

  public Node<E> getRight() {
    return right;
  }
}
