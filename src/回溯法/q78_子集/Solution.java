package 回溯法.q78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 *
 * 类型	题目链接
 * 子集、组合	子集、子集 II、组合、组合总和、组合总和 II
 * 全排列	全排列、全排列 II、字符串的全排列、字母大小写全排列
 * 搜索	解数独、单词搜索、N皇后、分割回文串、二进制手表
 *
 *
 *
 */
public class Solution {
    List<List<Integer>>  res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if(len <= 0 ) return res;
        res.add(new ArrayList());
        for(int i=0; i < nums.length; i++) {
            dfs(nums, i, new ArrayList());
        }
        return res;
    }

    public void dfs(int[] nums, int i , List<Integer> item){
        if(item.size()>=nums.length || i>=nums.length || i<0 ) return;
        item.add(nums[i]);
        res.add(new ArrayList(item));
        for(int j=i+1; j < nums.length; j++) {
            dfs(nums,j, item);
            item.remove(item.size()-1);
        }
    }
}
