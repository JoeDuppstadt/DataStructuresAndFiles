package DirectedGraph;

import java.util.Iterator;

public class DirGraph<T> implements Graph<T> {
    private int size;
    private Node head;
    List<Integer> list[];

    @Override
    public Iterator<T> bftIterator(T startpoint) {
        boolean[] visited = new boolean[size/** or size **/];
		List<T> bft = new AList<T>(); // create new list
		bft.add((T) startpoint); // add the starting point to the list 
		while (bft.isEmpty() == false) {
			int i = (int) bft.get((int) startpoint);
                        bft.remove(i);
			visited[i] = true; // set the location as visited
			head = head.getNext(); // should return the first element in the graph head.getElement() also works
			while (head != null) {
				if (visited[(Integer)head.getElement()] == false) {
					bft.add((T) head.getElement());
					visited[(Integer)head.getElement()] = true;
				}
				head = head.getNext();
			}          
		}
                return (Iterator<T>) bft.iterator();
	}
    

    @Override
    public Iterator<T> dftIterator(T startpoint) {
        boolean[] visited = new boolean[ size/** or Size()**/];
        List<T> DFT = new AList<T>();
        List<T> tempList = new AList<T>();

        int i = 0; 
        for(int a = (Integer) startpoint; a < size/** or size()**/; a++){
             // should add a graph size method^^^^^^^^^^^^^
            if(visited[(Integer)startpoint] == false) {
                // if the starting point has not been visited, add it to the list
                DFT.add((T) startpoint);
                visited[(Integer) startpoint] = true; // set the starting poin to visited
                while (DFT.isEmpty() == false) {           // this just adds the graph nodes to the list
                    int nodeIndex = (int) DFT.get(i);                     // |
                    DFT.remove(i);                                  // |
                    i++;                                            // |
                    List<Integer> listOfNodes = list[nodeIndex];    // |
                    for (int j = 0; j < listOfNodes.size(); j++) {  // |
                        int location = listOfNodes.get(j);          // |
                        if (visited[location] == false) {           // |
                            listOfNodes.add(location);              // |
                            visited[location] = true;               // V
                        }
                    }
                    // copies the listOfNodes to a tempList
                   for (int k = 0; k < listOfNodes.size(); k++ ){
                        tempList.add((T) listOfNodes.get(k));
                    }
                    DFT = tempList;
                }
            }
        }
        return (Iterator<T>)DFT.iterator();
        
    }

    @Override
    public boolean connected() {
        Iterator<T> it = bftIterator(0);

        if(it.isEmpty){
            return false;
        }
      int count = 0;
      while(it.hasNext()){  // go through the list and counts how the number of elements
         it.next();
         count++;
      }
      return (count == size /** or size() */);  // the the size determined from the add() method is the same as the count return true, else return false
   }
    
        private class Node{
        private T element;
        private Node next;
        private Node previous;
        
        
        public Node(T element){ 
            this.element = element;
        }
        
        public T getElement(){
            return element;
        }
        
        public void setElements(T element){
            this.element = element;
        }
        
        public Node getNext(){
            return next;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
        
        public Node getPrevious() {
            return previous;
        }
        
        public void setPrevious(Node previous) {
            this.previous = previous;
        }
        
    }  
    
}