package be.avondschool.fdw.hellojava.collecties.queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//Deque<E>:
//A linear collection that supports element insertion and removal at both
//ends. The name deque is short for "double ended queue" and is usually
//pronounced "deck". Most Deque implementations place no fixed limits on
//the number of elements they may contain, but this interface supports
//capacity-restricted deques.

//Insertion (head/tail): (=> exception vs null/false)
//- .addFirst/.addLast=.add vs .offerFirst/.offerLast=.offer
//- .removeFirst=.remove/.removeLast vs .pollFirst=.poll/.pollLast
//- .getFirst=.element/.getLast vs .peekFirst=.peek/.peekLast

//ArrayDeque<E>:
//Resizable-array implementation of the Deque interface. Array deques have
//no capacity restrictions; they grow as necessary to support usage.

public class VoorbeeldCollectiesDequeArrayDequeue {
    @Test public void main(){
        //Hier gebruikt als stack (LIFO) (=> *First varianten inzetten):
        Deque<String> ad = new ArrayDeque<>();
        ad.offerFirst("a");
        ad.offerFirst("b");
        ad.offerFirst("c");

        System.out.println("Peek: " + ad.peekFirst());
        System.out.println("Na peek, #: " + ad.size());
        System.out.println("Poll: " + ad.pollFirst());
        System.out.println("Na poll, #: " + ad.size());
    }
}
