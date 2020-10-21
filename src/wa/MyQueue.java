package wa;
import java.util.Stack;

public class MyQueue<E> {
  Stack<E> stack1;
  Stack<E> stack2;

  public MyQueue() {
    stack1 = new Stack<E>();
    stack2 = new Stack<E>();
  }

  public void enqueue(E item) {
    int stack1Size = stack1.size();
    for (int i = 0; i < stack1Size; i++) {
      stack2.push(stack1.pop());
    }

    stack1.push(item);

    int stack2Size = stack2.size();
    for (int i = 0; i < stack2Size; i++) {
      stack1.push(stack2.pop());
    }
  }

  public E dequeue() {
    return stack1.pop();
  }
}