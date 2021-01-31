package test;

public class Solution {
    public int sum(int x, int y) {
        int val;
        synchronized (Solution.class) {
            val = x +y;
        }
        return val;
    }

    public int sum1(int x, int y) {
        int val;
        synchronized (this) {
            val = x +y;
        }
        return val;
    }
}
