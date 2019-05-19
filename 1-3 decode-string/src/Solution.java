import java.util.Stack;

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
        //解法2： 使用栈来解决  2[ab3[cd]]4[xy]
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        StringBuilder res = new StringBuilder();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(isNum(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            } else if(s.charAt(i) == '['){
                numStack.push(num);//数字和对应的字符串入栈
                strStack.push("");//不过当前字符串为空，等待后续向里面插入
                num = 0;
            } else if(isSym(s.charAt(i))){
                if(strStack.isEmpty()){
                    res.append(s.charAt(i));
                } else {
                    strStack.push(strStack.pop() + s.charAt(i));
                }
            } else  if(s.charAt(i) == ']'){
                //出栈
                int count = numStack.pop();
                String str = strStack.pop();
                String strAll = "";
                for(int k = 0 ; k < count; k++){
                    strAll += str;
                }
                if(strStack.isEmpty()){
                    res.append(strAll);
                } else {
                    strStack.push(strStack.pop() + strAll);
                }
            }
        }
        return res.toString();
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }
    boolean isSym(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.decodeString("2[ab3[cd]]4[xy]"));
    }
}