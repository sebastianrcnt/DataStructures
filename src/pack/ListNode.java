package pack;

public class ListNode<E> extends Node<E> {
  private ListNode<E> next;
  public ListNode() {
    super();
  }

  public ListNode(E value) {
    super(value);
  }

  public void setNext(ListNode<E> next) {
    this.next = next;
  }

  public ListNode<E> getNext() {
    return next;
  }
}
