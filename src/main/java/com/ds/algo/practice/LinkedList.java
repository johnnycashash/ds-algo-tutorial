package com.ds.algo.practice;


import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Getter
public class LinkedList {

    Node head;

    public void addToFront(String data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    public void removeFromFront(){
        head=head.next;
    }

    @Setter
    @Getter
    public static class Node {
        String data;
        Node next;

        Node(String data){
            this.data=data;
        }

    }

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.addToFront("7");
        linkedList.addToFront("6");
        linkedList.addToFront("5");
        linkedList.addToFront("4");
        linkedList.addToFront("3");
        linkedList.addToFront("2");
        linkedList.addToFront("1");
        linkedList.addToFront("0");
        linkedList.removeFromFront();

        printList(linkedList.getHead());

        Stack<Node> stack=new Stack<>();
        pushStack(linkedList, stack);
        Node head = reverseFromStack(stack);
        //printList(head);
        head = reverseLinkedList(head);
        printList(head);
        Node node = middleLinkedList(head);
        System.out.println("middle="+node.getData());
        System.out.println("loop="+loopLinkedList(head));
    }

    private static Node reverseFromStack(Stack<Node> stack) {
        Node head=null;
        Node currHead=null;
        while (!stack.isEmpty()){
            Node popped = stack.pop();
            if(head==null){
                head=popped;
                currHead=popped;
            } else{
                currHead.next=popped;
                currHead=popped;
            }
        }
        if(currHead!=null){
            currHead.next=null;
        }
        return head;
    }

    private static void pushStack(LinkedList linkedList, Stack<Node> stack) {
        Node tempHead2= linkedList.getHead();
        while (tempHead2!=null){
            stack.push(tempHead2);
            tempHead2=tempHead2.next;
        }
    }

    private static void printList(Node head) {
        Node tempHead1= head;
        while (tempHead1!=null){
            System.out.println(tempHead1.getData());
            tempHead1=tempHead1.next;
        }
    }

    private static Node reverseLinkedList(Node head){
        Node prev=null;
        Node current=head;
        while (current!=null){
            Node nextNode=current.getNext();
            current.next=prev;
            prev=current;
            current=nextNode;
        }
        return prev;
    }
    private static Node middleLinkedList(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static boolean loopLinkedList(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow==fast;
    }
}
