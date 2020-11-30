package Microsoft.q103_二叉树的锯齿形层次遍历;

import java.util.Random;

/**
 * 洗牌算法
 *
 */
public class Solution1 {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution1(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        // 这个地方操作是因为调用后，如果修改该数组，并不影响原数组
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

}
