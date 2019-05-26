import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
	// write your code here
        int[] nums = {2, 7, 11, 15};
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, 9);
        Arrays.stream(res).forEach(System.out::print);

    }
}
