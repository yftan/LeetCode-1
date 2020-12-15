package Microsoft.q39_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 首先记得排序
        Arrays.sort(candidates);
        backTrace(candidates, target, new ArrayList(), 0);
        return res;
    }

    public void backTrace(int[] candidates, int target, List<Integer> item, int start) {
        if (target < 0) return;
        if (target == 0) {
            // 链表是地址，所以要重新生成
            res.add(new ArrayList<>(item));
        }

        // 主要是这个开始位置，如果是0的话，每次就会从头开始找就有有重复的情况[2,2,3][2,3,2][3,2,2]
        for (int i = start; i < candidates.length; i++) {
            item.add(candidates[i]);
            backTrace(candidates, target - candidates[i], item, i);
            item.remove(item.size() - 1);
        }
    }

    /**
     * 优化代码就行剪枝
     * <p>
     * [2,3,6,7] 7
     *
     * @param candidates
     * @param target
     * @param item
     * @param start
     */
    public void backTrace1(int[] candidates, int target, List<Integer> item, int start) {
        if (target < 0) return;
        if (target == 0) {
            // 链表是地址，所以要重新生成
            res.add(new ArrayList<>(item));
        }
        // 例如[2,2,2]这种情况它一直会遍历到结束才返回，因为后面已经没有比1小的了，所以直接返回即可
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            item.add(candidates[i]);
            backTrace(candidates, target - candidates[i], item, i);
            item.remove(item.size() - 1);
        }
    }
}