import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: WangYang
 * @Date: 2019/5/26 17:40
 * @Description:
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // 分治法，碰到运算符号，递归求解前一半的值和后一半的值，然后根据运算符号，计算两者构成的值。
        List<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*' ){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for(Integer l: left){
                    for(Integer r: right){
                        switch (c){
                            case '+': res.add(l + r);break;
                            case '-': res.add(l - r);break;
                            case '*': res.add(l * r);break;
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5").toString());
    }
}