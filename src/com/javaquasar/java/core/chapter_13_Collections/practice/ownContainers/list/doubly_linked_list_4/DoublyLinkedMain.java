package com.javaquasar.java.core.chapter_13_Collections.practice.ownContainers.list.doubly_linked_list_4;

class DoublyLinkedList<E>
{
    private class Node
    {
        Node prev;
        E item;
        Node next;
        private Node(Node prev, E item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    Node first = null;
    Node last = null;
    public void addToEnd(E it)
    {
        Node newNode = new Node(null,it,null);
        if(first == null)
        {
           first = last = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }
    public void addToBegin(E it)
    {
        Node newNode = new Node(null,it,first);
        Node oldFirst = first;
        first = newNode;
        newNode.next = oldFirst;
    }

    public void removeElement(E element){

        for (Node i = first; i != null ; i = i.next) {
            if(i.item == element){
                i.prev = i.prev.prev;
                i.item = i.next.item;
                i.next = i.next.next;
            }
        }
    }
    public void insertElementBefore(E element,E nextElement){
        boolean a = false;
        Node el = new Node(null,element,null);

            for (Node i = first; i != null; i = i.next) {
                if(!a) {
                if (i.next.item == nextElement) {
                    el.prev = i;
                    el.next = i.next;
                    i.next = el;
                    i.next.next.prev = el;
                    a = true;
                    break;
                }
            }
        }
    }

    public void printMeList()
    {
        for (Node i = first; i != null ; i = i.next) {
            System.out.println(i.item);
        }
    }
}


public class DoublyLinkedMain {
    public static void main(String[] args) {
            DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
        myList.addToEnd(5);
        myList.addToEnd(6);
        myList.addToEnd(7);
        myList.addToEnd(8);
        myList.addToEnd(9);
        myList.addToBegin(99);
        myList.removeElement(7);
        myList.insertElementBefore(777,8);
        myList.printMeList();
    }
}
