package Stack;

/**
 *
 * @author joecraigduppstadt
 */
public class StackSort<T extends Comparable<? super T>> {
    private VectorStack<T> store,temp;
    private int size;
    
    public StackSort(){
        store = new VectorStack<>();
        temp = new VectorStack<>();
        int size = 0;
    }

    
    public boolean add(T obj){
       if (obj == null)
           return false;
        findStackLocation(obj);
        store.push(obj);
        size++;
        emptyTempStack();
        return true;
    }
    
    public boolean contains(T obj){
        if(obj == null)
            return false;
        boolean found = false;
    
        findStackLocation(obj);
    
        while(!found && !store.empty() && store.peek().compareTo(obj) == 0){
            if(store.peek().equals(obj))
                found = true;
            else 
                temp.push(store.pop());
        }
            
     emptyTempStack();
    
    return found;
    }
    
    public boolean remove(T obj){
        if(obj == null)
            return false;
        boolean found = false;
    
        findStackLocation(obj);
    
        while(!found && !store.empty() && store.peek().compareTo(obj) == 0){
            if(store.peek().equals(obj)){
                store.pop();
                found = true;
            }
            else 
                temp.push(store.pop());
        }
            
     emptyTempStack();
    
    return found;
    
    }
    
    public Object [] toArray(){
        Object[] newArray = new Object[size];
        int i = 0;
        
        while(store.empty() != true){
            newArray[i] = store.pop();
            i++;
        }
        return newArray;
    }
    //bonus
    public Object [] reverseToArray(){
        Object[] reverseArray = new Object[size];
        int i = 0;
        
        while(store.empty() != true){
            temp.push(store.pop());
        }
        while(temp.empty() != true){
            reverseArray[i] = temp.pop();
            i++;
        }
        return reverseArray;
    }
    
    private void findStackLocation(T obj){
        while(!store.empty() && store.peek().compareTo(obj) < 0){
            temp.push(store.pop());
        } 
    }
    
    private void emptyTempStack(){
        while(!temp.empty()){
            store.push(temp.pop());
        }
    }
    
    
    
    
}
