import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return null;
        }
        double[] res = new double[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
            for(int i = 0; i < nums.length; i++){
            if(queue.size() == k){
                queue.pollFirst();
            }
            while(nums[i] > queue.getLast()){
                queue.pollLast();
            }
            queue.addLast(i);
            if()
        }
    }
}
