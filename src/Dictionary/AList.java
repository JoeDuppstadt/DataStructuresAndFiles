package Dictionary;

import Alist.List;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Implementation of an array list. In this implementation:
 *  - The list can be resized.
 *  - No null values allowed.
 */
public class AList<T> implements List<T>, Serializable {
    private Object[] list;
    private int size;
    private int capacity;
    public static final int DEFAULT_CAPACITY = 25;

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public AList(int initialCapacity) {
        capacity = initialCapacity;
        list = new Object[capacity];
    }

    @Override
    public void add(int index, T obj) {
        insert(index, obj);
    }

    private void insert(int index, T obj){
        if (obj == null)
            throw new NullPointerException();
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (size == capacity) {
            resize(capacity * 2);
        }
        //shift the elements down to make room for the new element
        for (int i = size; i > index; i--) {
            list[i] = list[i-1];
        }
        list[index] = obj;
        size++;
    }

    @Override
    public T remove(int index) {
        T old = get(index);
        for (int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[--size] = null;
        return old;
    }

    @Override
    public boolean add(T obj) {
        add(size, obj);
        return true;
    }

    @Override
    public void clear() {
        list = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public int indexOf(T obj) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(T obj) {
        for (int i = size-1; i >= 0; i--) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T)list[index];
    }

    @Override
    public boolean remove(T obj) {
        remover(obj);
        return true;
    }
    private boolean remover(T obj){
        int index = indexOf(obj);
        if (index < 0)
            return false;
        remove(index);
        return true;
    }

    @Override
    public T set(int index, T obj) {
        if (obj == null)
            throw new NullPointerException();
        T old = get(index);
        list[index] = obj;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] rarr = Arrays.copyOf(list, size);
        return rarr;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            private boolean nextCalled = false;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                T obj = (T)list[current++];
                nextCalled = true;
                return obj;
            }
            public void remove(int index) {
                if (!nextCalled)
                    throw new IllegalStateException();
                current--;
                for (int i = current; i < size-1; i++) {
                    list[i] = list[i+1];
                }
                list[--size] = null;
                nextCalled = false;
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {
            private int nextIndex = index;
            private boolean nextCalled = false, previousCalled = false, removeAdd = false, add = false;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public T next() {
                if(hasNext()){
                    nextCalled = true; previousCalled = false;
                    T obj = (T)list[nextIndex++];
                    removeAdd = false;
                    return obj;
                }
                else
                    throw new NoSuchElementException();
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            @Override
            public T previous() {
                if(hasPrevious()){
                    nextCalled = false; previousCalled = true;
                    T obj = (T)list[--nextIndex];
                    removeAdd = false;
                    return obj;
                }else{
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextIndex() {

                if (nextIndex == capacity) {
                    return size;
                }
                else{
                    return nextIndex;
                }
            }

            @Override
            public int previousIndex() {
                if(nextIndex -1 == 0){
                    return -1;
                }
                else{
                    return nextIndex-1;
                }
            }

            @Override
            public void remove() {
                if(!(previousCalled || nextCalled)){
                    throw new IllegalStateException();
                }
                else if(nextCalled){
                    int index = nextIndex-1;
                    for (int i = index; i < size; i++){
                        list[i] = list[i - 1];
                    }
                    nextIndex--;
                    size--;
                }
                else{
                    int index = nextIndex;
                    for(int i = index; i < size; i++){
                        list[i] = list[i + 1];
                    }
                    --size;
                }
            }

            @Override
            public void set(T e) {
                if(!(previousCalled || nextCalled || !removeAdd)){
                    throw new IllegalStateException();
                }
                else if(nextCalled){
                    list[--nextIndex] = e;
                    nextCalled = false;
                    ++nextIndex;
                }
                else{
                    list[nextIndex++] = e;
                    previousCalled = false;
                    --nextIndex;
                }
            }

            @Override
            public void add(T e) {
                /**
                 if((previousCalled == false || nextCalled == false)){
                 throw new IllegalStateException();
                 } */
                insert(nextIndex++, e);
                previousCalled = nextCalled = false;
                removeAdd = add = true;
            }

        };
    }

    private void resize(int newCapacity) {
        list = Arrays.copyOf(list, newCapacity);
        capacity = newCapacity;
    }

}

