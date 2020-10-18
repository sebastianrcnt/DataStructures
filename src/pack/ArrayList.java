package pack;

import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
  private E[] array;
  private int size;

  public ArrayList() { // O(1)
    size = 0;
    array = (E[]) new Object[1];
  }

  public int size() { // O(1)
    return this.size;
  }

  public E get(int at) { // O(1)
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return array[at];
  }

  public void set(E value, int at) {
    array[at] = value;
  }

  public void append(E value) { // O(n)
    if (size == array.length) {
      resize(2 * array.length);
    }
    array[size++] = value;
  }

  public void insert(E newValue, int at) { // O(n) or O(1)
    if (size == array.length) {
      resize(2 * array.length);
    }

    for (int i = size - 1; i >= at; i--) {
      array[i + 1] = array[i];
    }

    array[at] = newValue;
    size++;
  }

  public E delete(int at) { // O(n)
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E value = array[at];
    for (int i = at; i < size - 1; i++) {
      array[i] = array[i + 1];
    }

    array[size - 1] = null;

    size--;

    if (size > 0 && size == array.length / 4) {
      resize(array.length / 2);
    }
    return value;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void resize(int newSize) { // O(n)
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
    sb.append(array[size - 1]);
    sb.append(']');
    return sb.toString();
  }
}
