package skipList;

public class Client {
    static void main() {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        skiplist.search(0); // return False
        skiplist.add(4);
        skiplist.search(1);// return True
        skiplist.add(5);
        skiplist.search(3);  // return true
        skiplist.search(6); // return False
    }
}
