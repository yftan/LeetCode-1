package 堆相关.q973_最接近原点的K个点;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        // 这个地方生命点时候注意K和2
        int[][] res = new int[K][2];
        if (len < K) return res;
        List<Integer> sum = new ArrayList();
        // 1、首先算出所有点长度并排序
        for (int i = 0; i < len; i++) {
            int x = points[i][0];
            int y = points[i][1];
            sum.add(x * x + y * y);
        }
        Collections.sort(sum);
        int numk = sum.get(K - 1);
        int n = 0;
        // 2、在遍历一次把小于等于第K个值输出
        for (int i = 0; i < len; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if ((x * x + y * y) <= numk) {
                res[n][0] = x;
                res[n][1] = y;
                n++;
            }
        }
        return res;
    }


    /**
     * 大根堆(前 K 小) / 小根堆（前 K 大): 时间复杂度O(NlogK)
     * <p>
     * 本题是求前 K 小，因此用一个容量为 K 的大根堆，每次 poll 出最大的数，那堆中保留的就是前 K 小啦！
     * 这个方法比快排慢，但是因为 Java 中提供了现成的 PriorityQueue（默认小根堆），所以实现起来最简单，没几行代码
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest1(int[][] points, int K) {
        int len = points.length;
        int[][] res = new int[K][2];
        if (len < K) return res;
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> p2[1] * p2[1] + p2[0] * p2[0] - p1[1] * p1[1] - p1[0] * p1[0]);
        for (int i = 0; i < len; i++) {
            if (pq.size() < K) {
                pq.add(points[i]); // 用add或者offer都可以
            } else {
                // pq.comparator().compare(point, pq.peek()) > 0
                // 否则，判断当前点的距离是否小于堆中的最大距离，若是，则将堆中最大距离poll出，将当前点加入堆中。
                int[] tmp = pq.peek();
                if (tmp[0] * tmp[0] + tmp[1] * tmp[1] > points[i][0] * points[i][0] + points[i][1] * points[i][1]) {
                    pq.poll();
                    pq.add(points[i]);
                }
            }
        }

        // 返回堆中的元素
        int idx = 0;
        for (int[] point : pq) {
            res[idx++] = point;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {-2, 2}};
        new Solution().kClosest(arr, 1);
    }

}
