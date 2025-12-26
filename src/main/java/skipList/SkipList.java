package skipList;

import java.util.ArrayList;
import java.util.List;

class Skiplist {
    // save levels of linked list from bottom to top
    private List<DoublyLinkedList> skipList;

    // skip list should this many levels at most
    private final int MAX_LEVEL = 64;

    public Skiplist() {
        skipList = new ArrayList<>();

        // initially add doubly linked list to bottom
        DoublyLinkedList dll = new DoublyLinkedList();

        skipList.add(dll);
    }

    public boolean search(int target) {
        // start search from top level till bottom level to know the insert location
        // in bottom level
        DoublyLinkedList dll = skipList.getLast();
        Node currentNode = dll.head;
        while (currentNode != null) {

            // iterate on current list till the number is smaller than given num
            Node cursor = currentNode;
            while (cursor.next.value != null && cursor.next.value < target) {
                cursor = cursor.next;
            }

            if (cursor.next.value != null && cursor.next.value == target) {
                return true;
            }

            currentNode = cursor.down;
        }
        return false;
    }

    public void add(int num) {
        // start search from top level till bottom level to know the insert location
        // in bottom level

        // save the nodes along the way from top to bottom level
        List<Node> path = new ArrayList<>();
        DoublyLinkedList dll = skipList.getLast();
        Node currentNode = dll.head;
        while (currentNode != null) {
            // iterate on current list till the number is smaller than given num
            Node cursor = currentNode;
            while (cursor.next.value != null && cursor.next.value < num) {
                cursor = cursor.next;
            }

            path.add(cursor);

            currentNode = cursor.down;
        }

        // start inserting at bottom level and move up as per coin flip if head
        Node node = new Node(num);
        for (int i = path.size() - 1; i >= 0; i--) {

            // insert node
            Node smallerNode = path.get(i);

            node.next = smallerNode.next;
            node.prev = smallerNode;
            node.next.prev = node;
            node.prev.next = node;

            // new node for upper level
            Node newNode = new Node(num);
            newNode.down = node;

            node = newNode;

            // if coin flip is less than 0.5 then stop adding to upper level
            if (Math.random() < 0.5) {
                return;
            }
        }

        // keep on adding to upper level if coin flip is >= 0.5
        while (Math.random() > 0.5 && skipList.size() < MAX_LEVEL) {
            // create new level
            DoublyLinkedList newDll = new DoublyLinkedList();

            // link with previous dll
            DoublyLinkedList previousDll = skipList.getLast();
            newDll.head.down = previousDll.head;
            newDll.tail.down = previousDll.tail;

            // add new dll to skip list
            skipList.add(newDll);

            Node head = newDll.head;
            Node tail = newDll.tail;
            node.next = tail;
            node.prev = head;
            node.prev.next = node;
            node.next.prev = node;

            Node newNode = new Node(num);
            newNode.down = node;
            node = newNode;
        }
    }

    public boolean erase(int num) {
        boolean exist = search(num);
        if (exist == false) {
            return false;
        }

        // start search from top level till bottom level to know the insert location
        // in bottom level
        DoublyLinkedList dll = skipList.getLast();
        Node currentNode = dll.head;
        while (currentNode != null) {
            // iterate on current list till the number is smaller than given num
            Node cursor = currentNode;
            while (cursor.next.value != null && cursor.next.value < num) {
                cursor = cursor.next;
            }

            // found top node with value == num
            if (cursor.next.value != null && cursor.next.value == num) {
                currentNode = cursor.next;
                break;
            }

            currentNode = cursor.down;
        }

        // delete all node of value num from top till bottom
        Node node = currentNode;
        while (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // move a level down
            node = node.down;
        }

        return true;
    }
}

class Node {
    Integer value;
    Node next;
    Node prev;
    Node down;

    Node(Integer value) {
        this.value = value;
        next = null;
        prev = null;
        down = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }
}
/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */