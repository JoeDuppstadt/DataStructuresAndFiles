package ArrayQueue;

import java.util.NoSuchElementException;
import java.util.Arrays;


/**
 * Dynamic capacity queue implementation.
\ * @author Joseph Duppstadt
 * @param <T> 
 */
public class ArrayQueue<T> implements Queue<T> {
    private int size, front, back;
    private Object [] queue;
    private static final int DEFAULT_CAPACITY=32;
    
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    
    //TODO: initialization
    public ArrayQueue(int initialCapacity) {
        front = back = size = 0;
        queue = new Object[initialCapacity];
    }
    
    //TODO: If the queue is at capacity, resize the array.
    //otherwise, add to back, and update the value in back.
    //Normally, the add method should throw an exception when the
    //add fails. However, since we are resizing the array, this method
    //should never fail.
    @Override
    public boolean add(T obj) {
	if (size == queue.length){
            resize(2 * size); 
        }
        queue[back] = obj;
        back = (back + 1) % queue.length;
        size++;
        return true;
    }

	//otherwise return the value in the front of the queue.
    @Override
    public T element() {
	if (isEmpty() == true){
            throw new NoSuchElementException();
        }
        return (T) queue[front];
        
    }

    @Override
    public boolean offer(T obj) {
        try {
            add(obj);
        } catch (IllegalStateException e) {
            return false;
        }
        return true;
    }

    @Override
    public T peek() {
        try {
            return element();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T poll() {
        try {
            return remove();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

	//TODO: if the queue is empty, throw a NoSuchElementException.
	//Otherwise, remove the first element in the queue, and return
	//the object.
    @Override
    public T remove() {
        if(isEmpty() == true){
                    
            front = 0;
            back = 0;
            
            throw new NoSuchElementException();
        }
        else{
            T object = (T) queue[front];
            front = (front + 1) % queue.length;
            size--;
  
        return object;
        }

    }

    @Override
    public void clear() {
        front = back = size = 0;
        queue = new Object[queue.length];
    }

	//TODO: return true if the queue contains obj
    @Override
    public boolean contains(T obj) {
        for(int i = 0; i < size; i ++){
            int index = (front + i) % queue.length;
            
            if(queue[index]== obj){
                return true;
            }

        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

	//TODO: return the elements in the queue in an array.
    @Override
    public Object[] toArray() {
       Object [] array = new Object[size];
        for (int i = 0; i < size; i++){
            int index = (front + i) % queue.length;
            array[i] = queue[index];
        }
        return array;
    }
    
    //TODO: If newCapacity >= the current size,
    //create a new array and copy the values from the old to the new.
    //You might want to use the toArray method.
    //This new array will replace the queue array field.
    //If newCapacity < current size, throw an IllegalStateException.
    private void resize(int newCapacity) {
        if (newCapacity < size){
            throw new IllegalStateException("Capacity cannot be smaller that queue size");
        }
        Object [] temp = new Object[newCapacity];
        for (int i = 0; i < size; i++){
            int index = (front + i) % queue.length;
            temp[i] = queue[index];
        }
        front = 0; back = size;
        queue = temp;
    }
}
