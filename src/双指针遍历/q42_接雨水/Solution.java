package 双指针遍历.q42_接雨水;

/**
 * 暴力法o(n^2) 找出每个元素（柱子）上面的水量，可提前存储最大高度数组（两个左和右），最后遍历一次优化为o(n)
 */
public class  Solution {

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }


    /**
     * 双指针方法
     *
     * 该方法到解题思路：
     *
     * 初始化左边最大值leftMax，右边最大值rightMax
     * 每次比较height[left]与height[right]的大小，
     * if height[left] > height[right] 那么就让height[left] 与 leftMax左比较，如果小于则计算它的面积，如果大于则leftMax=height[left]
     *(此题的经典就是要从矮的一侧算起，每一侧都有一个最大值，出水量那个方柱肯定不会超过那一侧的最大值，因为最大值也是变化的，
     * 而且最大值是按顺序找的，可以保证在最大值的一侧肯定不会溢出。例如左侧的最大值，它的左侧到下一个最大值中间肯定不会溢出)
     * 例如：3，1，2，5；第一个最大值是3，那么在5之前最大值都不会变，直到leftMax=5。
     *
     * 第二种理解，先找两侧中到最小值，然后在根据两侧的最大值做计算。
     *
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if(height.length <= 2) {
            return 0;
        }
        int left =0 , right=height.length -1;
        int leftMax = height[left], rightMax = height[right];
        int area = 0;
        while (left < right) {
            if(height[left] < height[right]) {
                if (height[left]  < leftMax) {
                    area += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax){
                    area += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return area;

    }

    /**
     * 动态规划法
     *
     *
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height.length <= 2) {
            return 0;
        }
        int left =0 , right=height.length -1;
        int len = height.length;
        int leftMax = height[left];
        int rightMax = height[right];
        int[] leftMaxs = new int[len];
        int[] rightMaxs = new int[len];
        for (int i = 0; i < len; i++) {
            if( height[i] > leftMax) {
                leftMax = height[i];
            }
            leftMaxs[i] = leftMax;
        }
        for (int i = len-1; i >= 0 ; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
            rightMaxs[i] = rightMax;
        }

        int area=0;
        for (int i = 0; i < len; i++) {
            if(leftMaxs[i] < rightMaxs[i]) {
                area += leftMaxs[i] - height[i];
            } else {
                area += rightMaxs[i] - height[i];
            }
        }
        return area;

    }

    public static void main(String[] args) {

        int trap = new Solution().trap2(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
