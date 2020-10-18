package pack;

public interface List<E> {
  public void append(E value);
  public int size();
  public boolean isEmpty();
  public E get(int at);
  public void set(E value, int at);
}
