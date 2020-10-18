package pack;

public class Tree<E> {
  private Node<E> root;

  public Node<E> getRoot() {
    return root;
  }

  public void setRoot(Node<E> root) {
    this.root = root;
  }

  public boolean isEmpty() {
    if (root == null) {
      return true;
    } else {
      return root.isEmpty();
    }
  }
}
