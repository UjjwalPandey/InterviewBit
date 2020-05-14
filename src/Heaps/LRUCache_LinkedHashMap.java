/*

Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.

The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

    NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1



 */
package Heaps;

import java.util.*;

public class LRUCache_LinkedHashMap {
    public static void main(String[] args) {
        setLRU(2);
        set(1, 10);
        set(5, 12);
        System.out.println(get(5));        // returns 12
        System.out.println(get(1));        // returns 10
        System.out.println(get(10));       // returns -1
        set(6, 14);    // this pushes out key = 5 as LRU is full.
        System.out.println(get(5));        // returns -1
    }

    static Map<Integer, Integer> cache;
    static int SIZE;
    public static void setLRU(int capacity) {
        cache = new LinkedHashMap<>();
        SIZE = capacity;
    }

    public static int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        int val = cache.remove(key);
        cache.put(key, val);
        return val;
    }

    public static void set(int key, int value) {
        if (cache.containsKey(key))
            cache.remove(key);
        else if (cache.size() == SIZE) {
            Map.Entry<Integer, Integer> firstEntry = cache.entrySet().iterator().next();
            cache.remove(firstEntry.getKey());
        }

        cache.put(key, value);
    }
}
