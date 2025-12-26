package most_recently_used_queue;

class MRUQueue {
    private Node head;
    private Node tail;
    private final int BLOCK_SIZE;
    private Node[] blocks;
    public MRUQueue(int n) {
        BLOCK_SIZE = (int)Math.ceil(Math.sqrt(n));
        blocks = new Node[BLOCK_SIZE];

        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;

        // insert n items
        for(int i = 0; i < n; i++){
            Node node = new Node(i + 1);
            node.next = tail;
            node.prev = tail.prev;

            node.prev.next = node;
            node.next.prev = node;

            if(i % BLOCK_SIZE == 0){
                blocks[i / BLOCK_SIZE] = node;
            }
        }
    }

    public int fetch(int k) {
        k -= 1;

        int block_number = k / BLOCK_SIZE;
        int index = k % BLOCK_SIZE;

        int val = 0;

        // find the node within block
        Node cursor = blocks[block_number];
        int i = 0;

        while(cursor != tail){
            if(i == index){
                break;
            }

            i += 1;
            cursor = cursor.next;
        }

        val = cursor.val;

        // adjust block head
        if(index == 0){
            blocks[block_number] = blocks[block_number].next;
        }

        // remove this node
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;

        // append at tail
        cursor.next = tail;
        cursor.prev = tail.prev;

        cursor.prev.next = cursor;
        cursor.next.prev = cursor;

        // block heads after this blocks shift one node right
        for(int j = block_number + 1; j < blocks.length; j++){
            blocks[j] = blocks[j].next;
        }

        return val;
    }
}

class Node{
    Node prev;
    Node next;
    int val;
    Node(int val){
        this.val = val;
        prev = null;
        next = null;
    }
}
/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
