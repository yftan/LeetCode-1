package 并集查.q5650_执行交换操作后的最小汉明距离;

import java.util.*;

class Solution {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int res=0;

        int len = source.length;

        // 构建并查集
        UF uf = new UF(len);
        for(int i=0; i < allowedSwaps.length; i++) {
            int[] tmp = allowedSwaps[i];
            uf.union(tmp[0], tmp[1]);
        }

        // 解题思路
        // 1、考虑到有重复的数字出现，将target的值保存到map中key为具体的值，value是索引的列表，如果没有重复的只有一个值。
        // 2、遍历source数组，
        //  （1）首先判断source[i]这个值是否存在target中，如果没有直接+1；
        //   (2) 如果source[i]存在，在查询索引的下标是否符。即索引i的集合中是否包括了map[source[i]]中的索引，如果存在，则删除（假设有重复的元素，如果没有就不用这步），
        //       遍历map[source[i]]中的索引，如果不都符合，就+1
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i < len; i++) {
            map.putIfAbsent(target[i], new LinkedList<Integer>());
            map.get(target[i]).add(i);
        }
        for(int i=0; i < len; i++) {
            if(map.get(source[i]) == null) {
                res++;
                continue;
            }
            List<Integer> list = map.get(source[i]);
            Iterator<Integer> it = list.iterator();
            boolean isFlag =false;
            while(it.hasNext()){
                Integer idx = it.next();
                if(uf.isConnect(i, idx)){
                    // 移除当前节点
                    it.remove();
                    isFlag= true;
                    break;
                }
            }
            if(!isFlag){
                res++;
            }
        }

        return res;

    }

    public class UF{
        // 记录该节点的父元素
        int[] parent;
        // 记录不同根节点的，树的深度
        int[] rank;

        UF(int n){
            parent = new int[n];
            for(int i=0; i< n; i++) {
                parent[i] = -1;
            }
            rank = new int[n];
        }

        /**
         查找x的根节点
         **/
        public int find(int x){
            while(parent[x] != -1) {
                x = parent[x];
            }
            return x;
        }

        // 合并两个树
        public void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root) {
                return;
            } else if(rank[x_root] > rank[y_root] ){
                parent[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root] ){
                parent[x_root] = y_root;
            } else {
                // rank[x_root] == rank[y_root]
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            return;
        }

        // 判断两个索引是否相连
        public boolean isConnect(int x, int y){
            return find(x) == find(y);
        }
    }
}