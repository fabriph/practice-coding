/*
 * Book: Elements of Programming Interviews
 * Exercise 25.9 Zip linked list
 */

import java.io.*;
import java.util.*;

class Main {
  private static Node calcSecondHalf(Node head, int n) {
    Node result = null;
    Node current = head;
    int i = 0;
    while (2 * (i+1) < n) {
      current = current.next;
      i++;
    }
    result = current.next;
    current.next = null;
    return result;
  }

  private static Node reverse(Node head) {
    Node result = null;
    Node current = head;
    Node next = null;
    while (current != null) {
      next = current.next;

      current.next = result;
      result = current;

      current = next;
    }
    return result;
  }

  private static Node merge(Node list1, Node list2) {
    Node result = list1;
    Node tail = list1;

    Node current1 = list1.next;
    Node current2 = list2;
    Node temp = null;
    while (current2 != null) {
      temp = current2.next;
      current2.next = null;
      tail.next = current2;
      tail = current2;
      current2 = temp;

      if (current1 != null) {
        temp = current1.next;
        current1.next = null;
        tail.next = current1;
        tail = current1;
        current1 = temp;
      }
    }
    return result;
  }

  private static Node zipList(Node head) {
    int n = 0;
    Node current = head;
    while (current != null) {
      n++;
      current = current.next;
    }
    System.out.println("n = " + String.valueOf(n));

    Node secondHead = calcSecondHalf(head, n);
    System.out.println(head);
    System.out.println(secondHead);

    secondHead = reverse(secondHead);
    System.out.println(secondHead);

    return merge(head, secondHead);
  }

  public static void main(String[] args) {
    Node list = new Node(1);
    list.next = new Node(2);
    list.next.next = new Node(3);
    list.next.next.next = new Node(4);
    list.next.next.next.next = new Node(5);
    list.next.next.next.next.next = new Node(6);
    // list.next.next.next.next.next.next = new Node(7);

    System.out.println(list);

    Node result = zipList(list);
    System.out.println(result);
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
