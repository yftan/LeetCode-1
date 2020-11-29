package q119_杨辉三角II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        if(rowIndex < 0) return list.get(0);
        List<Integer> num1 = new ArrayList<>();
        num1.add(1);
        list.add(num1);
        if(rowIndex == 0) return list.get(0);;
        List<Integer> num2 = new ArrayList<>();
        num2.add(1);
        num2.add(1);
        list.add(num2);
        if(rowIndex == 1) return list.get(1);;
        for(int i=2 ; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int j=0; j < list.get(i-1).size()-1; j++){
                List<Integer> tmpList = list.get(i-1);
                tmp.add(tmpList.get(j) + tmpList.get(j+1));
            }
            tmp.add(1);
            list.add(tmp);
        }
        return list.get(rowIndex);
    }

    public List<Integer> getRow1(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
