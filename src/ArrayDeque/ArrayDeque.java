package ArrayDeque;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author josephduppstadt
 */
/*
 * READ THIS CAREFULLY:
 * Your task is to implement ArrayDeque. the index head and tail should point to
 * the first value and the last value in the Deque. This is NOT like the implementation
 * of ArrayQueue, where back pointed to the first free value after the last value in the
 * queue.
 * In other words, DO NOT JUST COPY ARRAYQUEUE. IT WON'T WORK.
 * The add methods are included for you. Implement all missing methods.
 */

/**
 *
 * @author sjw
 */
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int head, tail, size;
    private Object[] deque;
    public static final int DEFAULT_CAPACITY = 16;

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayDeque(int initialCapacity) {
        deque = new Object[initialCapacity];
        tail = -1;
    }
    
    @Override
    public boolean addFirst(T obj) {
        if (atCapacity()) {
            resize(2 * deque.length);
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            head = (deque.length + head - 1) % deque.length;
        }
        deque[head] = obj;
        size++;
        return true;
    }

    @Override
    public boolean addLast(T obj) {
        if (atCapacity()) {
            resize(2 * deque.length);
        }
        if (isEmpty()) {
            head = tail = 0;
        } else {
            tail = (tail + 1) % deque.length;
        }
        deque[tail] = obj;
        size++;
        return true;
    }

    @Override
    public boolean offerFirst(T obj) {
        if(addFirst(obj) == true){
            return true;
        }
        else return false;
    }

    @Override
    public boolean offerLast(T obj) {
        if(addLast(obj) == true){
            return true;
        }
        else return false;
    }

    @Override
    public T getFirst() {
        if (isEmpty() == true)
            throw new NoSuchElementException("Queue is Empty");
        
        T object = (T) deque[head];
            return object;

    }

    @Override
    public T getLast() {
        if (isEmpty() == true)
            throw new NoSuchElementException("Queue is Empty");
        
        T object = (T) deque[head];
            return object;
      

    }

    @Override
    public T peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T removeFirst() {
         if (isEmpty() == true){
            head = tail = 0;
        }
        T Remove = getFirst();
        head = (head + 1) % deque.length;
        size--;
        return Remove;
          
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            head = tail = 0;
        }
         
        T Remove = getFirst();
        tail = (tail - 1) % deque.length;
        size--;
        return Remove;  
    
    }

    @Override
    public T pollFirst() {
          try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T pollLast() {
          try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void clear() {
        size = 0;
    }

    public boolean contains(T obj) {
        for (int i = 0; i < size; i++){
            if (obj == deque[i])
                return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++){
            int index = (head + i) % deque.length;
            array[i] = deque[index];
        }
        return array;
    }
    
    private boolean atCapacity() {
        return size == deque.length;
    }
    
    private void resize(int newCapacity) {
        Object [] temp = new Object[newCapacity];
        for (int i = 0; i < size; i++){
            int index = (head+i) % deque.length;
            temp[i] = deque[index];
        }
        deque = temp;
        head = 0;
        tail = size-1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = head;
            private int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T obj = (T) deque[current];
                    counter++;
                    current = (current + 1) % deque.length;
                    return obj;
                } 
                else {
                     throw new NoSuchElementException();
                }
            }
        };
    }
}
