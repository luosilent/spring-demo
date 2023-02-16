package com.node;

/**
 * @author luo
 * @date 2023/2/13 16:02
 */
public class LinkedList {
    public Node head;
    public Node tail;

    public void insertAtHead(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void insertAtTail(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.prev = tail;
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtHead(1);
        linkedList.insertAtHead(3);
        linkedList.insertAtHead(4);
        System.out.println(linkedList.find(3).next.value);
    }
}

