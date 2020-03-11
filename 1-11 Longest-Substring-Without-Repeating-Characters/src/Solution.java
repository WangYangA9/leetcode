import java.util.HashSet;
import java.util.Set;

class Solution {
    //解法1： 暴力法
//    public int lengthOfLongestSubstring(String s) {
//        int ans = 0;
//        Set<Character> set = new HashSet<>();
//        for(int i = 0; i < s.length(); i++) {
//            set.clear();
//            for(int j = i; j < s.length(); j++) {
//                if(!set.contains(s.charAt(j))){
//                    set.add(s.charAt(j));
//                    ans = Math.max(ans, set.size());
//                } else {
//                    break;
//                }
//            }
//        }
//        return ans;
//    }

    //解法2：滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while(i < s.length() && j < s.length()){
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("qrsvbspk"));
    }
}