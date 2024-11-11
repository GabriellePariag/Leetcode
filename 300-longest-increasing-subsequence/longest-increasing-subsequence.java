class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max;
        int[] tracker = new int[n];
        tracker[n-1] = 1;

        for (int i = n-2; i >= 0; i--) {
            max = 0;
            for (int j = i+1; j < n; j++) {
                if(nums[i] < nums[j] && tracker[j] > max) max = tracker[j];
            }
            tracker[i] = max+1;
        }

        max = 0;
        for (int i = 0; i < n; i++) {
            if(tracker[i] > max) max = tracker[i];
        }

        return max;
    }
}

/*
set substring nums[n-1] = 1 because there is no increasing subseqence
move onto nums[n-2]. if it less than nums[n-1], set its count to 2
move onto nums[n-3].
    go until you reach every element after curr
        if curr < element it is valid for a subsequence
        compare the subsequence len of that element to min
    once the min is gotten, set count of curr to min+1
keep going till n-n


*/