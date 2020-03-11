import java.util.HashMap;
import java.util.Map;

class Solution {
    //解法一，滑动窗口法
    public static String minWindow(String s, String t) {
        String ans = "";
        if(s == null || s.length() == 0 || t== null || t.length() == 0){
            return ans;
        }
        Map<Character, Integer> tCharacter = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            int count = tCharacter.getOrDefault(t.charAt(i), 0);
            tCharacter.put(t.charAt(i), count + 1);
        }
        Map<Character, Integer> tempSCharacter = new HashMap<>();
        int l = 0, r = 0;
        int formed = 0;
        while(r < s.length()){
            Character c = s.charAt(r++);
            if(tCharacter.containsKey(c)){
                int count = tempSCharacter.getOrDefault(c, 0);
                tempSCharacter.put(c, count + 1);
                if(count + 1 == tCharacter.get(c)){
                    formed++;
                }
            }
            while(l <=r && formed == tCharacter.keySet().size()){
                if(ans.length() == 0 || ans.length() > r - l){
                    ans = s.substring(l, r);
                }
                Character lc = s.charAt(l++);
                int count = tempSCharacter.getOrDefault(lc, 0);
                if(count > 0 && count-1 < tCharacter.get(lc)){
                    formed--;
                }
                if(count == 1){
                    tempSCharacter.remove(lc);
                    break;
                } else if(count > 1){
                    tempSCharacter.put(lc, count - 1);
                }
                if(count > 0 && count-1 < tCharacter.get(lc)){
                    formed--;
                }
            }
        }
        return ans;
    }

    public static boolean compare(Map<Character, Integer> tempSCharacter,  Map<Character, Integer> tCharacter){
        if(tempSCharacter.size() != tCharacter.size()){
            return false;
        }
        boolean ans = true;
        for(Character c: tempSCharacter.keySet()){
            if(tempSCharacter.get(c) < tCharacter.get(c)){
                ans = false;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
