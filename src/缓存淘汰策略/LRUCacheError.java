package 缓存淘汰策略;

import java.util.LinkedList;

/**
 * 自己写的，超时了。
 */
class LRUCacheError {

    // 利用双向链表
    LinkedList<Node> list = null;
    int cap = 0;

    public LRUCacheError(int capacity) {
        list = new LinkedList<Node>();
        cap = capacity;
    }

    public int get(int key) {
        for(int i=0; i < list.size(); i++) {
            Node node = list.get(i);
            if(node.key == key) {
                Node head = new Node(node.key, node.value);
                // 删除该node
                list.remove(i);
                // 放到第一位
                list.addFirst(head);
                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.get(key) != -1) {
            list.get(0).setValue(value);
        } else {
            //这个要放在里面
            if(list.size() >= this.cap){
                // 如果满了，移除最后一位
                list.removeLast();
            }
            Node head = new Node(key, value);
            list.addFirst(head);
        }
    }

    class Node{
        public int key;
        public int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public void setValue(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCacheError lruCache = new LRUCacheError(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        System.out.println(lruCache.get(2));
    }
}