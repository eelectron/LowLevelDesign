package leastFrequentlyUsedCache;

public class Client {
    static void main() {
        LFUCache lfuCache = new LFUCache(2);

        lfuCache.put(1, 1); // cache is {1=1}
        lfuCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lfuCache.get(1)); // return 1

        lfuCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lfuCache.get(2)); // return -1 (not found)
        System.out.println(lfuCache.get(3)); // return 3

        lfuCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lfuCache.get(1)); // return -1 (not found)
        System.out.println(lfuCache.get(3)); // return 3
        System.out.println(lfuCache.get(4)); // return 4
    }
}
