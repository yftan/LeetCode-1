package 剑指.q56_数组中数字出现的次数_I;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == 1) {
                res[i++] = next.getKey();
            }
        }
        return res;
    }

    /**
     * 通过异或的方式进行
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers1(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int mask = 1;
        while ((xor & mask) != 0) {
            mask <<= 1;
        }

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        res[0] = a;
        res[1] = b;

        return res;
    }

}
