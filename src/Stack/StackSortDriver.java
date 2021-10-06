package Stack;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josephduppstadt
 */
public class StackSortDriver {
    public static void main(String[] args){
    
        System.out.println("Creating a stack of integers...");
        StackSort<Integer> stack = new StackSort<>();
        System.out.println("Adding another value...(Should be true)" + stack.add(14));
        System.out.println("Adding another value...(Should be true)" + stack.add(1));
        System.out.println("Adding another value...(Should be true)" + stack.add(5));
        System.out.println("Adding another value...(Should be true)" + stack.add(7));
        System.out.println("Adding another value...(Should be true)" + stack.add(4));
        System.out.println("Checking to see if 4 is in the set (true)" + stack.contains(4));
        System.out.println("Removing 4...(Should be true)" + stack.remove(4));
        System.out.println("Removing 4...(Should be false)" + stack.remove(10));
        
        
    
    
    }
}
