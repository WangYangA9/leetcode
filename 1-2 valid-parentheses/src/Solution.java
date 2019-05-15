import java.util.*;

/**
 * Created by Administrator on 2019/5/14 0014.
 */
public class Solution {

    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        if(s.length() % 2 > 0){
            return false;
        }
        /*
        //解法1：使用栈顺序匹配
        List<String> left = Arrays.asList("(", "{", "[");
        HashMap map = new HashMap<String, String>(){{
            put(")", "(");
            put("]", "[");
            put("}", "{");
        }};
        Stack<String> stack = new Stack<>();
        int size = s.length();
        for(int i = 0 ; i < size; i++){
            String elem = s.substring(i, i + 1);
            if(left.contains(elem)){
                stack.push(elem);
            } else {
                if(stack.size() == 0){
                    return false;
                }
                String pop = stack.pop();
                if(!map.get(elem).equals(pop)){
                    return false;
                }
            }
        }
        if(stack.size() > 0){
            return false;
        }

        return true;
        */
        //解法2：使用字符数组
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c: str){
            if(stack.size() == 0){
                stack.push(c);
            } else if(isMatch(stack.peek(), c)){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
    boolean isMatch(char c1, char c2){
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
