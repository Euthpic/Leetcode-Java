package LRU缓存;

import java.util.HashMap;
import java.util.Map;

//使用双向链表和map实现
//双向链表用于维护使用情况,最近使用过的放头部,最久未使用的放尾部,这样驱逐的时候直接驱逐尾部,简单高效
//get操作先用map的get获取value,然后把对应的node挪到头部
//put操作先判断key存不存在,若存在则修改value,然后把对应的node挪到头部;若不存在则在头部新建node
//在双向链表的实现中，使用一个伪头部（dummy head）和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。

public class LRUCache {

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            //如果key存在,把对应的node挪到头部,并且返回value
            DLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            //如果key不存在,返回-1
            return -1;
        }
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            //如果key存在,则更新node的value,然后像get一样把对应的node挪到头部
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            //如果key不存在,则新增一个node,如果新增后超出容量,则移除末尾节点
            DLinkedNode node = new DLinkedNode(key, value);
            addToHead(node);
            if (size > capacity) {
                removeTail();
            }
        }

    }

    public void removeNode(DLinkedNode node) {
        node.next.prev=node.prev;
        node.prev.next=node.next;
        cache.remove(node.key);
        --size;
    }

    public void addToHead(DLinkedNode node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        cache.put(node.key ,node);
        ++size;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void removeTail() {
        removeNode(tail.prev);
    }

}
