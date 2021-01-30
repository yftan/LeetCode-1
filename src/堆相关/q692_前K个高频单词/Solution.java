package 堆相关.q692_前K个高频单词;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String , Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }


        // 小顶堆，每次出去的都是最小的
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2)->{
            // 如果单词出现的数量相等
            if(count.get(w1) == count.get(w2)) {
                return w2.compareTo(w1);
            } else {
                return count.get(w1) - count.get(w2);
            }
        });

        for (String word: count.keySet()) {
            pq.offer(word);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<String> res = new ArrayList();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        // 因为是小顶堆出来的，肯定是从小到大排列的，故翻转
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("tyf".compareTo("tyf1"));
    }
}
