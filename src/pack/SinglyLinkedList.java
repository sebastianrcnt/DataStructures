package pack;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {
  protected ListNode<E> head;
  private int size;

  public SinglyLinkedList() {
    head = null;
    size = 0;
  }

  public int search(E value) { // O(n)
    ListNode<E> currentNode = head;
    for (int i = 0; i < size; i++) {
      if (value == currentNode.getValue()) {
        return i;
      }
      currentNode = currentNode.getNext();
    }
    return -1;
  }

  public int size() {
    return this.size;
  }

  private ListNode<E> getLastListNode() {
    if (isEmpty())
      return null;
    ListNode<E> node = head;
    while (node.hasNext()) {
      node = node.getNext();
    }
    return node;
  }

  public void append(E value) {
    if (isEmpty()) {
      head = new ListNode<E>(value);
    } else {
      ListNode<E> lastListNode = getLastListNode();
      lastListNode.setNext(new ListNode<E>(value));
    }
    size++;
  }

  public void insert(E value, int at) {

    size++;
  }

  private ListNode<E> getNode(int at) {
    if (at < 0 || at >= size) {
      throw new IndexOutOfBoundsException();
    } else if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      ListNode<E> node = head;
      for (int i = 0; i < at; i++) {
        node = node.getNext();
      }
      return node;
    }
  }

  public E get(int at) {
    ListNode<E> node = getNode(at);
    return node.getValue();
  }

  public void set(E value, int at) throws IndexOutOfBoundsException {
    ListNode<E> node = getNode(at);
    node.setValue(value);
  }

  public boolean isEmpty() {
    return head == null;
  }
}
