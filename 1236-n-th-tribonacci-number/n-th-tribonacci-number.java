class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1]; // stores the nth tribonacci value
        
        for(int i = 0; i < n+1; i++) {
            // base cases
            if(i == 0) {
                dp[i] = 0;
                continue;
            } 
            if(i == 1 || i == 2) {
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];

    }
}