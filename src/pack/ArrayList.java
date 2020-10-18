package pack;

import java.util.NoSuchElementException;

public class ArrayList<E> {
  private E[] array;
  private int size;

  public ArrayList() {
    size = 0;
    array = (E[]) new Object[1];
  }

  public int size() {
    return this.size;
  }

  public E get(int at) {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return array[at];
  }

  public void append(E item) {
    if (size == array.length) {
      resize(2 * array.length);
    }
    array[size++] = item;
  }

  public void insert(E newItem, int at) {
    if (size == array.length) {
      resize(2 * array.length);
    }

    for (int i = size - 1; i >= at; i--) {
      array[i + 1] = array[i];
    }

    array[at] = newItem;
    size++;
  }

  public E delete(int at) {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E item = array[at];
    for (int i = at; i < size - 1; i++) {
      array[i] = array[i + 1];
    }

    array[size-1] = null;

    size--;

    if (size > 0 && size == array.length / 4) {
      resize(array.length / 2);
    }
    return item;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void resize(int newSize) {
    E[] temp = (E[]) new Object[newSize];
    for (int i = 0; i < size; i++) {
      temp[i] = array[i];
    }
    array = temp;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < size - 1; i++) {
      sb.append(array[i].toString());
      sb.append(' ');
    }
    sb.append(array[size-1]);
    sb.append(']');
    return sb.toString();
  }

  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    arrayList.append(0);
    arrayList.append(1);
    arrayList.append(2);
    arrayList.append(3);
    arrayList.delete(2);

    System.out.println(arrayList.toString());
  }
}
