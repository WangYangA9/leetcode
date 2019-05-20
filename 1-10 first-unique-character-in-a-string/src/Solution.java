import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: WangYang
 * @Date: 2019/5/20 13:08
 * @Description:
 */
public class Solution {
    public int firstUniqChar(String s) {
        //解法1 使用map
//        Map<Character, Integer> map = new LinkedHashMap<>();
//        for(char c: s.toCharArray()){
//            if(map.get(c) == null){
//                map.put(c, 1);
//            } else {
//                map.put(c, map.get(c) + 1);
//            }
//        }
//        for(int i = 0; i < s.length(); i++){
//            if(map.get(s.charAt(i)) == 1){
//                return i;
//            }
//        }
        //使用数组
        int[] num = new int[26];
        for(char c: s.toCharArray()){
            num[c-'a'] ++;
        }
        for(int i = 0; i < s.length(); i++){
            if(num[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
