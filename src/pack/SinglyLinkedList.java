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

  public void insertFront(E value) {
    if (isEmpty()) {
      append(value);
    } else {
      ListNode<E> node = new ListNode<E>(value);
      node.setNext(head);
      head = node;
    }
    size++;
  }

  public void insertAfter(E value, int at) {
    ListNode<E> node = getNode(at);
    ListNode<E> next = node.getNext();
    ListNode<E> nodeToinsertAfter = new ListNode<E>(value);
    node.setNext(nodeToinsertAfter);
    nodeToinsertAfter.setNext(next);
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

  public static <F> void is(F i1, F i2) {
    if (i1 == i2) {
      System.out.printf("[PASS] %s == %s\n", i1.toString(), i2.toString());
    } else {
      System.out.printf("[FAIL] %s != %s\n", i1.toString(), i2.toString());
    }

  }
  public static void main(String[] args) {
    SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
    sll.append(0);
    sll.append(1);
    sll.append(2);
    sll.append(3);
    sll.append(4);

    is(sll.get(2), 2);
    is(sll.get(3), 3);
    is(sll.size(), 5);
    is(sll.getNode(2).getValue(), 2);
    sll.set(10, 2);
    is(sll.get(2), 10);
    sll.insertAfter(99, 2);
    is(sll.get(2), 10);
    is(sll.get(3), 99);

    sll.insertFront(5);
    is(sll.get(1), 0);
    is(sll.get(0), 5);
    is(sll.size(), 7);
  }
}
