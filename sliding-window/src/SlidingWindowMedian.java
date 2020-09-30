import java.util.*;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return null;
        }
        double[] res = new double[nums.length - k + 1];
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.size() == k){
                set.remove()
            }
        }
    }
}
