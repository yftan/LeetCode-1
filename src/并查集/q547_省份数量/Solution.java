package 并查集.q547_省份数量;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UF uf = new UF(len);
        for(int i =0; i < len;i++) {
            for(int j=0; j <len; j++) {
                if(isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.size;

    }

    class UF{
        // 记录父节点
        int[] parent;
        // 记录树的高度
        int[] rank;

        int size;

        // 构造函数
        UF(int n){
            parent = new int[n];
            // 没有父节点就是-1
            for(int i=0; i< n ;i++) {
                parent[i] = -1;
            }
            rank = new int[n];
            size = n;
        }

        // 查找根节点
        public int find(int x){
            while(parent[x]!=-1) {
                x = parent[x];
            }
            return x;
        }

        // 合并两个树
        public void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            // 如果相等，本来就是一个树
            if(x_root == y_root) {
                return;
            } else if(rank[x_root] < rank[y_root]){
                parent[x_root] = y_root;
            } else if(rank[x_root] > rank[y_root]){
                parent[y_root] = x_root;
            } else{
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            size--;
        }


    }
}
