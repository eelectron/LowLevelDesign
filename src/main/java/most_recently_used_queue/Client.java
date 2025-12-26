package most_recently_used_queue;

public class Client {
    public static void main(String[] args) {
        MRUQueue mruQueue = new MRUQueue(3);
        System.out.println(mruQueue.fetch(3)); // return 3, the 3rd element is 3
        System.out.println(mruQueue.fetch(3)); // return 5, the 5th element is 3
//        System.out.println(mruQueue.fetch(3)); // return 2, the 2nd element is 3
    }
}
