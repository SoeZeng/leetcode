package hash_table;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LRUCache_146 {
    public static void main(String[] args) {

    }
}

/**
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 *
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
 * 则应该 逐出 最久未使用的关键字。
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 */
class LRUCache {

    List<Integer> keyCache;
    int[] dict = new int[10001];
    int capacity = 0;

    public LRUCache(int capacity) {
        Arrays.fill(dict, -1);
        keyCache = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(dict[key] != -1) {
            keyCache.remove(keyCache.indexOf(key));
            keyCache.add(key);
        }
        return dict[key];
    }

    public void put(int key, int value) {
        if(dict[key] != -1) {
            keyCache.remove(keyCache.indexOf(key));
        } else if(keyCache.size() == this.capacity) {
            System.out.println(keyCache.get(0) + ", " +key);
            dict[keyCache.get(0)] = -1;
            keyCache.remove(0);
        }

        keyCache.add(key);
        dict[key] = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
