package ArrayDeque;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Double-ended queue, or Deque (pronounced "deck") interface.Based on the
 Java API implementation.
 * @param <T>
 */
public interface Deque<T> extends Queue<T> {
    public boolean addFirst(T obj);
    public boolean addLast(T obj);
    public boolean offerFirst(T obj);
    public boolean offerLast(T obj);
    public T getFirst();
    public T getLast();
    public T peekFirst();
    public T peekLast();
    public T removeFirst();
    public T removeLast();
    public T pollFirst();
    public T pollLast();
    
    //Queue methods
    
    public default boolean add(T obj) {
        return addLast(obj);
    }
    
    public default boolean offer(T obj) {
        return offerLast(obj);
    }
    
    public default T element() {
        return getFirst();
    }
    
    public default T peek() {
        return peekFirst();
    }
    
    public default T remove() {
        return removeFirst();
    }
    
    public default T poll() {
        return pollFirst();
    }
    
    //Stack methods
    
    public default void push(T obj) {
        addFirst(obj);
    }
    
    public default T pop() {
        return removeFirst();
    }
}