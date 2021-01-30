package 数组操作.q986_区间列表的交集;

import java.util.Arrays;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lena = A.length;
        int lenb = B.length;
        if(lena ==0 || lenb ==0) {
            return new int[0][0];
        }
        int[][] res = new int[lena+lenb][2];
        // 记录在不同的数组内走到了第几个区间
        int idx=0, idxa= 0, idxb=0;
        while(idxa<lena && idxb < lenb) {
            // 注意比较的是两个不同区间最左边的最大值，以及最右边的最小值，如果maxleft < minright就存在重合区间
            int maxLeft = Math.max(A[idxa][0],B[idxb][0]);
            int minRight = Math.min(A[idxa][1],B[idxb][1]);
            // 存在重合区间
            if(maxLeft <= minRight) {
                res[idx++] = new int[]{maxLeft, minRight};
            }
            // 移动索引的原则，判断区间最右边的索引，小的向后移动
            if(A[idxa][1]  < B[idxb][1]){
                idxa++;
            } else {
                idxb++;
            }
        }
        res = Arrays.copyOf(res, idx);
        return res;
    }
}
