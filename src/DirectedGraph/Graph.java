package DirectedGraph;

import java.util.Iterator;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josephduppstadt
 * @param <T>
 */
public interface Graph<T> {
public Iterator<T> bftIterator(T startpoint);
public Iterator<T> dftIterator(T startpoint);
public boolean connected() ;
}


