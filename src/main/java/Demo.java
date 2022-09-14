import hashmap.MyHashMap;
import hashmap.MyMap;
import list.MyArrayList;
import list.MyLinkedList;
import list.MyList;
import queue.MyLinkedQueue;
import queue.MyQueue;
import stack.MyLinkedStack;
import stack.MyStack;

public class Demo {
    public static void main(String[] args) {
        //arrayListTest();
        //linkedListTest();
        //linkedQueueTest();
        //linkedStackTest();
        //hashMapTest();
    }

    private static void arrayListTest() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        list.display();

        list.remove(3);
        list.remove(1);
        list.remove(2);
        list.remove(4);
        list.remove(5);
        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(0);
        list.remove(1);
        list.remove(0);
        list.remove(0);

        System.out.println(list.size());
        list.display();
        System.out.println(list.size());

        list.clear();
    }

    private static void linkedListTest() {
        MyList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.display();
        System.out.println();

        System.out.println(list.get(4));
        System.out.println(list.get(3));

        list.remove(3);

        list.display();

        list.remove(1);

        System.out.println();
        list.display();

        list.remove(0);

        System.out.println();
        list.display();

        list.remove(1);

        System.out.println();
        list.display();

        list.remove(0);

        System.out.println();
        list.display();
    }

    private static void linkedQueueTest() {
        MyQueue<Integer> queue = new MyLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

//        queue.remove(1);
//        queue.remove(3);
//        queue.remove(2);
//        queue.remove(5);
//        queue.remove(3);
//        queue.remove(4);
//        queue.remove(6);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void linkedStackTest() {
        MyStack<Integer> myStack = new MyLinkedStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

//        myStack.remove(2);
//        myStack.remove(3);
//        myStack.remove(4);
//        myStack.remove(1);

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    private static void hashMapTest() {
        MyMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "Vo");
        hashMap.put(1, "4");
        hashMap.put(3, "eq");
        hashMap.put(4, "qw");
        hashMap.put(17, "17");
        hashMap.put(33, "33");

        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(17));
        System.out.println(hashMap.get(33));
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(1));


        hashMap.remove(2);
        hashMap.remove(4);
        hashMap.remove(3);
        hashMap.remove(33);
        hashMap.remove(17);
        hashMap.remove(1);
        hashMap.remove(33);
    }
}
