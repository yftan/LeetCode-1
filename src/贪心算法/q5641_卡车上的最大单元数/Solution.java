package 贪心算法.q5641_卡车上的最大单元数;

import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 贪心算法+排序
        // 将物品价值最贵的排在前面
        Arrays.sort(boxTypes, (o1, o2)-> o2[1]- o1[1]);
        int res = 0;
        // boxTypes[i][0] 为数量，boxTypes[i][1]为价值
        for(int i=0; i< boxTypes.length;i++){
            if(truckSize - boxTypes[i][0] > 0) {
                res += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                // 如果boxTypes[i][0]数量大于剩下的truckSize，那么直接用剩下的truckSize*价值即可
                res += truckSize* boxTypes[i][1];
                return res;
            }
        }
        return res;
    }
}
