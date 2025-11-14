class Solution {
    public int rob(int[] nums) {
        /*
        state: which house you are at
        */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(i == 1) {
                dp[1] = nums[1];
                continue;
            }
            else if(i == 2) {
                dp[2] = nums[2] + nums[0];
                continue;
            }
            dp[i] = Math.max(nums[i] + dp[i-2], nums[i] + dp[i-3]);
        }

        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] > max) max = dp[i];
        }

        return max;
        
    }
}