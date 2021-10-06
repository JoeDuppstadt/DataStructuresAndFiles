package Alist;


import java.util.ListIterator;
import java.util.NoSuchElementException;


public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> al = new AList<>();
        al.add(120);
        al.add(11);
        al.add(22);
        al.add(99);
        al.add(-1);
        al.add(42);
        al.add(206);
        System.out.println("List initialized. Initial values should be: ");
        System.out.println("120 11 22 99 -1 42 206");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();

        System.out.println("Getting iterator at index 0");
        ListIterator<Integer> lit = al.listIterator(0);
        System.out.println("hasNext should be true: " + lit.hasNext());
        System.out.println("hasPrevious should be false: " + lit.hasPrevious());
        System.out.println("next should be 120: " + lit.next());
        System.out.println("next should be 11: " + lit.next());
        System.out.println("next should be 22: " + lit.next());
        System.out.println("hasPrevious should be true: " + lit.hasPrevious());
        System.out.println("previous should be 22: " + lit.previous());
        System.out.println("previousIndex should be 1: " + lit.previousIndex());
        System.out.println("nextIndex should be 2: " + lit.nextIndex());
        System.out.println("set should change 22 to 44.");
        lit.set(44);
        System.out.println("Reset iterator for position 0.");
        while(lit.hasPrevious())
            lit.previous();
        System.out.println("nextIndex should be 0: " + lit.nextIndex());
        System.out.println("Values should be: ");
        System.out.println("120 11 44 99 -1 42 206");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("next should be 120: " + lit.next());
        System.out.println("next should be 11: " + lit.next());
        System.out.println("next should be 44: " + lit.next());
        System.out.println("next should be 99: " + lit.next());
        System.out.println("next should be -1: " + lit.next());
        System.out.println("next should be 42: " + lit.next());
        lit.set(21);
        System.out.println("set should change 42 to 21.");
        System.out.println("Values should be: ");
        System.out.println("120 11 44 99 -1 21 206");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("next should be 206: " + lit.next());
        System.out.print("next should throw exception: ");
        try {
            lit.next();
            System.err.println("***FAIL***");
            System.exit(1);
        } catch (NoSuchElementException e) {
            System.out.println("PASS");
        }
        System.out.print("remove should remove 206");
        lit.remove();
        System.out.println("Size should be 6: " + al.size());
        System.out.println("120 11 44 99 -1 21");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("previous should be 21: " + lit.previous());
        System.out.println("previous should be -1: " + lit.previous());
        System.out.println("previous should be 99: " + lit.previous());
        System.out.println("remove should remove 99");
        lit.remove();
        System.out.println("120 11 44 -1 21");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("next should return -1: "+ lit.next());
        System.out.println("previous should be -1: " + lit.previous());
        System.out.println("previous should be 44: " + lit.previous());
        System.out.println("previous should be 11: " + lit.previous());
        System.out.println("previous should be 120: " + lit.previous());
        System.out.print("previous should throw an exception: ");
        try {
            lit.previous();
            System.err.println("***FAIL***");
            System.exit(1);
        } catch (NoSuchElementException e) {
            System.out.println("PASS");
        }
        System.out.println("Remove should remove 120");
        lit.remove();
        System.out.println("11 44 -1 21");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("Reinitialize the interator at 3");
        lit = al.listIterator(3);
        System.out.println("Previous should return -1: " + lit.previous());
        System.out.println("Adding 5 values");
        for (int i = 0; i < 5; i++) {
            lit.add(i);
        }
        System.out.println("11 44 0 1 2 3 4 -1 21");
        for (int x : al)
            System.out.print(x + " ");
        System.out.println();
        System.out.println("previous should return 4: " + lit.previous());
        System.out.println("Next should return 4: " + lit.next());
        System.out.println("Add 5 at position");
        lit.add(5);
        System.out.print("set should throw exception: ");
        try {
            lit.set(5);
            System.out.println("***FAIL***");
            System.exit(1);
        } catch (IllegalStateException e) {
            System.out.println("PASS");
        }
        System.out.print("remove should throw exception: ");
        try {
            lit.remove();
            System.out.println("***FAIL***");
            System.exit(1);
        } catch (IllegalStateException e) {
            System.out.println("PASS");
        }
        System.out.println("DONE");
    }

}
