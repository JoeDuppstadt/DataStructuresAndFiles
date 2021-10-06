package LinkedStack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
	private Node top;
	
   public T push(T obj) {
		Node n = new Node(obj);
		n.setNext(top);
		top = n;
		return obj;
	}

    public T peek() {
		if (empty())
			throw new EmptyStackException();
		return top.getElement();
	}

    public T pop() {
		T obj = peek();
		top = top.getNext();
		return obj;
	}

    public boolean empty() {
		return top == null;
	}
	
	private class Node {
		private T element;
		private Node next;
		
		public Node(T element) {
			this.element = element;
		}
		
		public T getElement() {
			return element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
}