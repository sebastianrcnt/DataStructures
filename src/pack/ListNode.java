package pack;

public class ListNode<E> extends Node<E> {
  private Node<E> next;
  public ListNode() {
    super();
  }

  public ListNode(E value) {
    super(value);
  }
}
