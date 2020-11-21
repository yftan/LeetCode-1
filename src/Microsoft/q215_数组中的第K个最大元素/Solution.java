package Microsoft.q215_数组中的第K个最大元素;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    /**
     * ======方法一、利用快排，分区的特点========
     **/
    public void quickSort(int[] nums, int start, int end, int k) {
        if (start >= end) return;

        int mid = nums[end];
        int left = start;
        int right = end;
        while (left < right) {
            while (nums[right] <= mid && left < right) {
                right--;
            }
            while (nums[left] >= mid && left < right) {
                left++;
            }
            swap(nums, right, left);
        }
        if (nums[left] < mid) {
            swap(nums, left, end);
            // 如果这个时候进行了交换，证明该位置就是分割点，如果它正好等于k-1就结束计算
            if (left == k - 1) return;
        } else {
            left++;
        }
        quickSort(nums, start, left - 1, k);
        quickSort(nums, right + 1, end, k);

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * ======方法二：利用优先队列（大顶堆、小顶堆都可以）========
     * 该方法是小顶堆
     *
     **/
    public Integer findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            Integer peek = queue.peek();
            if(peek < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    /**
     * 方法三：大顶堆
     */
    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

}