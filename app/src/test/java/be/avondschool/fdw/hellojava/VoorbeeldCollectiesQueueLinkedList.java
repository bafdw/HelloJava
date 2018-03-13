package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//Interface java.util.Queue<E>:
//   https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
//Extends: Collection<E>
//
//Insertion: (=> exception vs false/null)
//- .add vs .offer (bij volle capacity-restrictive queue)
//Extraction/inspection (head): (=> exception vs null/false)
//- .remove/.element vs .poll/.peek (bij lege queue)

//Class java.util.LinkedList<E>:
//   https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
//Implements List<E>, Deque<E>
//
//All of the operations perform as could be expected for a doubly-linked
//list. Operations that index into the list will traverse the list from the
//beginning or the end, whichever is closer to the specified index.
public class VoorbeeldCollectiesQueueLinkedList {
    @Test public void main(){
        Queue<String> ll = new LinkedList<String>(); // implementeert ook Deque
        ll.offer("Informatica");
        ll.offer("Boekhouden");
        ll.offer("Topografie");

        System.out.println("Peek: " + ll.peek());
        System.out.println("Na peek, #: " + ll.size());
        System.out.println("Poll: " + ll.poll());
        System.out.println("Na poll, #: " + ll.size());

        for(String e: ll)
            System.out.print(e + " ");
    }
}
