package HashDictionary;

/**
 *
 * @param <K>
 * @param <V>
 */
public class HashDictionary<K,V> implements Dictionary<K,V> {
    private Object[] table;
    private static final int DEFAULT_CAPACITY = 19;
    private int capacity;
    private int size;
    
    public HashDictionary() {
        this(DEFAULT_CAPACITY);
    }
    
    public HashDictionary(int initialCapacity) {
        capacity = initialCapacity;
        table = new Object[capacity];
    }
    
    //Go through all the entries in the table. If null, skip to the next entry.
    //If not null, add all keys from chain into the List
    //Verify that the list size is equal to the dictionary size, then
    //return the List.
    @Override
    public List<K> keys() {
        List<K> key = new AList<>();
        for(int i = 0; i < capacity; i++){
            Node n = (Node)table[i];
            while(n != null){
                key.add(n.getKey());
                n = n.getNext();
            }
        }
        assert key.size() == size;
        return key;
    }

    //Same as keys method, but return the list of values.
    @Override
    public List<V> values() {
        List<V> value = new AList<>();
        for(int i = 0; i < capacity; i++){
            Node n = (Node)table[i];
            while(n != null){
                value.add(n.getValue());
                n = n.getNext();
            }
        }
        assert value.size() == size;
        return value;    
    }

    @Override
    public V get(Object key) {
        Node n = (Node)table[hashIndex((K)key)];
        while (n != null) {
            if (n.getKey().equals(key))
                return n.getValue();
            else
                n = n.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public V put(K key, V value) {
        int index = hashIndex(key); 
         Node n = (Node) table[index];  
         while (n != null) {
            if (n.key.equals(key)){
               break;
            }
            n = n.next;
         }
         if (n != null) {
            n.value = value;
         }
         if(size == capacity){
             capacity = resize(capacity);
             return null;
         }
         else {
            Node newNode = new Node(key, value);
            newNode.key = key;
            newNode.value = value;
            newNode.next = (Node) table[index];
            table[index] = newNode;
            size++;  
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = hashIndex((K)key);
        Node current = (Node)table[index];
        
        if(current.getKey().equals(key)){
            table[index] = current.getNext();
            size--;
            return current.getValue();
        }
        Node previous = current;
        current = current.getNext();
        while(current != null){
            if (current.getKey().equals(key)){
                previous.setNext(current.getNext());
                size--;
                return current.getValue();
            }
            previous = current;
            current.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        for(int i = 0; i < size() - 1; i++){
            if((K)table[i] == key){
                return true;
            }
        }
        return false;
    }
    
    
    private int hashIndex(K key) {
        int index = key.hashCode() % capacity;
        return (index < 0)?(index+capacity):index;
    }
    
    private int resize(int capacity){
        return capacity *= 2;
    }

    
        
    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}