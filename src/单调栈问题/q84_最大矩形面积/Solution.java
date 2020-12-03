package 单调栈问题.q84_最大矩形面积;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 参考地址：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 *
 */
public class Solution {

    /**
     * 暴力解法,时间复杂度O(n*n)
     *
     * 主要思路就是穷举了所有矩形块的之间的最小高度 * 之间的宽度。逐一对比
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length <=0) return 0;
        int len = heights.length;
        int max = heights[0];
        for(int i=0;i< len;i++) {
            int minHeight = heights[i];
            for (int j=i; j <len;j++) {
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max,minHeight*(j-i+1));
            }
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        // 使用单调栈方式，主要是找到第一个小于它的高度，那么就可以计算面积
        // 利用哨兵的小技巧，减少判断。类似与链表中的虚拟头指针
        if(heights == null || heights.length < 0) return 0;
        if (heights.length == 1) return heights[0];
        int len = heights.length;
        // 左右增加守卫，都是0。在递归的时候就可以让栈中的元素进行弹出计算。建议直接Debug
        int[] newHeights = new int[len+2];
        newHeights[0]=0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len+1]=0;

        // stack中存入的是索引，不是高度。因为索引相减可以得到高度
        Deque<Integer> stack = new LinkedList<Integer>();
        // 先把哨兵左边加入栈中
        stack.addLast(0);
        int max = 0;
        for(int i=1; i < len+2; i++) {
            // 1。这个地方要找到比这个高度还要小的值在结束。
            // 以例子中【6，2】为例。到了（高度2，新索引是5）之后，就会开始计算 6*（5-3-1） ，5*（5-2-1）
            // 2。这个地方因为使用了左边守卫，所以不需要判断是否为空
            while(newHeights[i] < newHeights[stack.peekLast()]) {
                int curHeight = newHeights[stack.pollLast()];
                int curWeight = i - stack.peekLast() -1;
                max = Math.max(max, curHeight*curWeight);
            }
            stack.addLast(i);
        }

        // 3。这个地方因为使用了右边守卫，所以不存在剩余在栈李的值。否则还需要按照上述方法在计算
        return max;

    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution solution = new Solution();
        int res = solution.largestRectangleArea1(heights);
        System.out.println(res);
    }


}
