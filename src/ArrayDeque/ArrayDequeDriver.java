package ArrayDeque;

public class ArrayDequeDriver {

    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>(9);
        q.addFirst(1);
        q.addFirst(2);
        q.addFirst(3);
        q.addLast(4);
        q.addLast(5);
        q.addLast(6);

        for (int val : q) {
            System.out.print(val + " ");
        }
        System.out.println();

    }
}
