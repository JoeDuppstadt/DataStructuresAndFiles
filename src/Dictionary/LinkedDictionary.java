package Dictionary;

public class LinkedDictionary<K, V> implements Dictionary<K, V> {
    private int size;
    private Node head;
        
    @Override
    public V put(K key, V value){
        if(isEmpty()){
            Node n = new Node(key, value, null);
            n.setNext(n);
            head = n;
            size = 1;
            return null;
        }else{
            Node n = getNodeContaining(key);
            if(n == null){
                n = new Node(key, value, head.getNext());
                head.setNext(n);
                size++;
                return null;
            }else{
                V oldValue = n.getValue();
                n.setValue(value);
                return oldValue;
            }
        }    
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    private Node getNodeContaining(K key){
        Node current = head;        
        for(int i = 0; i < size-1; i++){
            if(current.getKey().equals(key)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    private Node getNodeBefore(K key){
        Node previous = head;
        Node current = head.getNext();
        for(int i = 0; i < size; i++){
            if(current.getKey().equals(key)){
                return previous;
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public List<K> keys() {
        List<K> al = new AList<>();
        Node current = head;
        for(int i = 0; i < size; i++){
            al.add((K)current.getKey());
            current = current.getNext();
        }
        return (List<K>) al;
    }
    
    @Override
    public List<V> values() {
        List<V> al = new AList<>();
        Node current = head;
        for(int i = 0; i < size; i++){
            al.add((V)current.getValue());
            current = current.getNext();
        }
        return (List<V>) al;
    }    

    @Override
    public V get(Object key) {
        if(key == null){
            return null;
        }
        else{
            Node n = getNodeContaining((K) key);
            if(n == null){
                return null;
            }else{
                return n.getValue();
            }
        }  
    }

    @Override
    public V remove(Object key){
        Node n = getNodeBefore((K)key);
        if(n != null){
            if(n.getNext().equals(head)){
                head = n;
            }
            V oldValue = n.getNext().getValue();
            n.setNext(n.getNext().getNext());
            size--;
            if(isEmpty()){
                head = null;
            }
            return oldValue;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        Node current = head.getNext();
        
        for(int i = 0; i < size; i++){
            if(current.getKey().equals(key)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private class Node{
        private V value;
        private K key;
        private Node next;
        
        public Node(K key, V value, Node head ){ 
            this.key = key;
            this.value = value;
            this.next = head;
        }
        
        public V getValue(){
            return value;
        }
        
        public void setValue(V value){
            this.value = value;
        }
        
        public K getKey(){
            return key;
        }
        
        public void setkey(K key){
            this.key = key;
        }
        
        public Node getNext(){
            return next;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
    } 
}