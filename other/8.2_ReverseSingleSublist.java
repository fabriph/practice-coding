/*
 * Book: Elements of Programming interviews
 * Exercise 8.2 Reverse a single sublit
 */

import java.io.*;
import java.util.*;

class Main {
  private static void reverseSublist(
      Node list, int start, int end) {
    // assumes start and end are valid positions in the list
    if (start == 0) {
      throw new RuntimeException("cant start from head");
      // actually we can, but keeping it simpler for coding
    }

    // advance list to the last element that doesn't need reversion
    int elementsToSwap = end - start + 1;
    while (start - 1 > 0) {
      list = list.next;
      System.out.println("advance " + String.valueOf(list.val));
      start--;
      end--;
    }

    //      s         e
    // l    t          
    // 0 -> 1 -> 2 -> 3 -> 4 -> ...
    Node tailSublist = list.next;
    elementsToSwap--;  // the first element doesn't need swap
    while (elementsToSwap > 0) {
      elementsToSwap--;

      // remove current element
      // put current it in the begininig of the list
      // advance current

      // elementsToSwap = 0
      // l = 0 -> 3 -> 2 ...
      // t = 1 -> 4 ...
      // c = 3 -> 2 ...

      Node current = tailSublist.next;
      tailSublist.next = current.next;

      current.next = list.next;
      list.next = current;
    }
  }

  public static void main(String[] args) {
    Node list = new Node(0);
    list.next = new Node(1);
    list.next.next = new Node(2);
    list.next.next.next = new Node(3);
    list.next.next.next.next = new Node(4);
    list.next.next.next.next.next = new Node(5);
    list.next.next.next.next.next.next = new Node(6);

    System.out.println(list);

    reverseSublist(list, 1 , 3);

    System.out.println(list);
  }

  private static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }

    public String toString() {
      return String.valueOf(this.val) +
        (next != null ? (" -> " + next.toString()) : ";");
    }
  }
}
