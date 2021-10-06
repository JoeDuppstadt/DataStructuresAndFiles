package ArrayQueue;

public class ArrayQueueDriver {
	public static void main(String [] args) {
	Queue<Integer> q = new ArrayQueue<>(9);
        System.out.println("Adding 7 items...");
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println("Removing two items...");
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println("Adding four items...");
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println("Removing 6 items...");
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.print("Next item in queue is: ");
        System.out.println(q.element());
        System.out.println("size = " + q.size());
        for (Object i : q.toArray()) {
            System.out.println(i);
        }
        System.out.println("size = " + q.size());
        for (int i = 0; i < 3; i++) {
            System.out.println("removing: " + q.remove());
        }
        System.out.println("size = " + q.size());
        System.out.println("isEmpty: " + q.isEmpty());
        System.out.println("Attempting to add 10 items...");
        for (int i = 0; i < 10; i++) {
            if (!q.offer(i))
                System.out.println("Failed to add item: " + i);
        }
        
        while(!q.isEmpty())
            System.out.println("removing " + q.remove());
        System.out.println(q.size());
        
	}
}