import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Integer> cache = new HashMap<>();

    public int maxSubArray(int[] nums) {
        return solve(nums, 0, false);
    }

    private int solve(int[] nums, int i, boolean mustPick) {
        if (i >= nums.length) {
            return mustPick ? 0 : Integer.MIN_VALUE;
        }
        
        String key = i + "," + mustPick;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int pick = nums[i] + solve(nums, i + 1, true);
        int notPick = mustPick ? 0 : solve(nums, i + 1, false);
        int result = Math.max(pick, notPick);

        cache.put(key, result);
        return result;
    }
}
