package oop;

public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data){
        //Add new data as a node
        Node newNode = new Node(data);

        //Check if list is null
        if(list.head == null){
            list.head = newNode;
        }else{
            //Get last node
            Node lastNode = list.head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }

            //assign new node to the next node of last one
            lastNode.next = newNode;
        }

        return list;
    }

    //TODO
    public static LinkedList delete(LinkedList list, int data){
        Node currentNode = list.head;
        Node prevNode = null;

        if(currentNode != null && currentNode.data == data){
            list.head = currentNode.next;

            return list;
        }

        while (currentNode != null && currentNode.data != data){
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode != null){
            prevNode.next = currentNode.next;
        }

        if(currentNode == null){
            System.out.println(data + " not found!");
        }

        return list;
    }

    public static boolean ifExisted(LinkedList list, int data){
        Node currentNode = list.head;

        while (currentNode.next != null){
            if(currentNode.data == data){
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    public static void print(LinkedList list){
        Node currentNode = list.head;

        System.out.print("LinkedList is: ");

        while (currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);

        print(list);
        System.out.println(ifExisted(list, 3));

        delete(list, 5);
        print(list);
    }
}
