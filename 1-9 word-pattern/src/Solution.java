import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WangYang
 * @Date: 2019/5/20 11:12
 * @Description:
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] splitStr = str.split(" ");
        if(pattern.length() != splitStr.length){
            return false;
        }
        //解法1： 单map
        Map<Character, String> map = new HashMap<>();
        for(int i = 0 ; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String split = splitStr[i];
            if(map.get(c) == null){
                if(map.containsValue(split)){
                    return false;
                }
                map.put(c, split);
            } else {
                if(!map.get(c).equals(split)){
                    return false;
                }
            }
        }
        return true;
        //解法2： 双map
//        Map<Character, String> map = new HashMap<>();
//        Map<String, Character> map2 = new HashMap<>();
//        for(int i = 0; i < pattern.length(); i++){
//            char c = pattern.charAt(i);
//            String split = splitStr[i];
//            if(map.get(c) != null && !map.get(c).equals(split)){
//                return false;
//            } else {
//                map.put(c, split);
//            }
//
//            if(map2.get(split) != null && !map2.get(split).equals(c)){
//                return false;
//            } else {
//                map2.put(split, c);
//            }
//        }
//        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }
}
