package pack;

public class LinkedList<E> {
  protected ListNode<E> head;
  private int size;
  
  public LinkedList() {
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

  public int 
}
