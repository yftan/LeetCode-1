package Microsoft.q239_滑动窗口最大值;

import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列里面存的是索引
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int len = nums.length;
        int[] result = new int[len -k +1];
        for(int i=0; i<len; i++) {
            // 每次遍历的这个值，与队列中的元素从后向前进行比较。如果队列元素小于它就弹出
            while(!queue.isEmpty() &&  nums[queue.peekLast()] < nums[i] ) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断第一位置是否还在窗口中
            if( i-k +1 > queue.peekFirst()){
                queue.pollFirst();
            }
            // 已经到达滑动窗口的值了，就开始进行计算了
            if(i+1-k >= 0) {
                result[i+1-k] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
