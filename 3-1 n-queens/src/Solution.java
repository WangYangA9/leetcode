import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2019/5/15 0015.
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backTrace(0, n, new String[n], new int[n], new int[2 * n], new int[2 * n], res);

        return res;
    }
    //理解为，每一行都要选择一个位置放置皇后
    public void backTrace(int k, //当前所处行数
                          int n, //n阶
                          String[] temp, //当前解
                          int[] colHash,
                          int[] leftTiltHash,
                          int[] rightTiltHash,
                          List<List<String>> res//输出
    ){
        if(k == n){
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(temp));
            res.add(list);
            return;
        }
        for(int i = 0; i < n; i++){//按列扫描
            if(colHash[i] == 0 && leftTiltHash[k + i] == 0 && rightTiltHash[k - i + n] == 0){
                //rowsHash[k] = 1;
                colHash[i] = 1;
                leftTiltHash[k + i] = 1;
                rightTiltHash[k - i + n] = 1;
                char[] chars = new char[n];
                for(int s = 0; s < n; s++){
                    if(s == i){
                        chars[s] = 'Q';
                    } else {
                        chars[s] = '.';
                    }
                }
                String str =  new String(chars);
                temp[k] = str;
                backTrace(k + 1, n, temp, colHash, leftTiltHash, rightTiltHash, res);

//                rowsHash[k] = 0;
                colHash[i] = 0;
                leftTiltHash[k + i] = 0;
                rightTiltHash[k - i + n] = 0;
            }
        }
    }
}