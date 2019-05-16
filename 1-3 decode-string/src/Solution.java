/**
 * @Author: WangYang
 * @Date: 2019/5/16 17:11
 * @Description:
 */
class Solution {
    public String decodeString(String s) {
        //解法一：没想到有嵌套[]的情况，单纯使用字符串函数很难解决，需要使用类似二元表达是感觉来解决
//        StringBuilder res = new StringBuilder();
//        int startIndex = 0;
//        while(s.indexOf("[", startIndex) != -1){
//            int lefrIndex = s.indexOf("[", startIndex);
//            int rightIndex = s.indexOf("]", startIndex);
//            while(!isNum(s.charAt(startIndex))){
//                res.append(s.charAt(startIndex));
//                startIndex++;
//            }
//            int num = Integer.parseInt(s.substring(startIndex, lefrIndex));
//            for(int i = 0 ; i < num; i++){
//               res.append(s.substring(lefrIndex + 1, rightIndex));
//            }
//            startIndex = rightIndex + 1;
//        }
//        if(startIndex < s.length()){
//            res.append(s.substring(startIndex));
//        }
//
//        return res.toString();
        //解法2： 使用栈来解决
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.decodeString("2[ab3[cd]]4[xy]"));
    }
}