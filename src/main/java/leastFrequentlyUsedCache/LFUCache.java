package leastFrequentlyUsedCache;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    // maximum capacity of cache
    private final int CAPACITY;

    // keep frequencies of key in sorted doubly linked list
    // head has least frequently used item and tail has most frequently used item
    private Node head;
    private Node tail;

    // keep the key value in map
    private Map<Integer, Node> keyMap;

    // map to track of head of same number sequence
    // 1 -> 1 -> 1 -> 3 -> 3 -> 3 -> 3 -> 4 -> 4 -> 5 -> 6 -> 9
    // useCounter -> Node
    private Map<Integer, Node> useCounterMap;

    // current number of keys
    private int size;

    public LFUCache(int capacity) {
        CAPACITY = capacity;
        size = 0;

        // initialize doubly linked list
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;

        keyMap = new HashMap<>();

        useCounterMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyMap.get(key);

        // key not found
        if (node == null) {
            return -1;
        }

        // key found
        int value = node.value;

        // increase it's use counter
        Integer oldUseCounter = node.useCounter;
        Integer newUseCounter = node.useCounter + 1;

        // current chunk head
        Node currentHead = useCounterMap.get(oldUseCounter);

        // adjust the node's position

        // if front number is present then add in front of it's head
        if (useCounterMap.containsKey(newUseCounter) == true) {
            // previous node can be new head
            Node previousNode = node.prev;

            // adjust position
            Node chunkHead = useCounterMap.get(newUseCounter);

            // remove from current position
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // add in front of next head
            node.next = chunkHead.next;
            node.prev = chunkHead;

            node.prev.next = node;
            node.next.prev = node;

            // this become new chunk head
            useCounterMap.put(newUseCounter, node);

            // if this node was a head earlier than make previous node head
            Node oldHead = useCounterMap.get(oldUseCounter);
            if (oldHead == node) {
                if (previousNode.useCounter == oldUseCounter) {
                    useCounterMap.put(oldUseCounter, previousNode);
                } else {
                    // remove old head
                    useCounterMap.remove(oldUseCounter);
                }
            }
        } else if (currentHead.prev.useCounter == currentHead.useCounter) {
            // current node is also a head
            if (node == currentHead) {
                useCounterMap.put(newUseCounter, node);
                useCounterMap.put(node.prev.useCounter, node.prev);
            } else {
                // remove
                node.prev.next = node.next;
                node.next.prev = node.prev;

                // move in front
                node.prev = currentHead;
                node.next = currentHead.next;
                node.prev.next = node;
                node.next.prev = node;
                useCounterMap.put(newUseCounter, node);
            }
        } else {
            // 1 -> 1 -> 1 -> 4 -> 6 -> 6 -> 6
            useCounterMap.put(newUseCounter, node);
            useCounterMap.remove(oldUseCounter);
        }

        node.useCounter = newUseCounter;

        return value;
    }

    public void put(int key, int value) {
        // if new node and capacity is full then remove least frequently used item
        Node node = keyMap.get(key);

        if (node == null) {
            if (size == CAPACITY) {
                Node lfuNode = head.next;
                lfuNode.prev.next = lfuNode.next;
                lfuNode.next.prev = lfuNode.prev;

                keyMap.remove(lfuNode.key);

                if (useCounterMap.get(lfuNode.useCounter) == lfuNode) {
                    useCounterMap.remove(lfuNode.useCounter);
                }
            }
            else{
                size += 1;
            }

            node = new Node(key, value);
            node.useCounter = 1;
            keyMap.put(key, node);

            Node headOfOne = useCounterMap.get(node.useCounter);
            if (headOfOne == null) {
                node.next = head.next;
                node.prev = head;
                node.prev.next = node;
                node.next.prev = node;
            } else {
                node.next = headOfOne.next;
                node.prev = headOfOne;
                node.prev.next = node;
                node.next.prev = node;
            }

            // make this new head of 1 series
            useCounterMap.put(node.useCounter, node);
        } else {
            // update value
            node.value = value;

            // it's use will be incresed by 1
            get(key);
        }
    }
}

class Node {
    Integer key;
    Integer value;
    Integer useCounter;
    Node prev;
    Node next;

    Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        useCounter = null;
        prev = null;
        next = null;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */