class Solution {
    public int maxArea(int[] height) {
        // two pointers on the left and right
        int l = 0;
        int r = height.length-1;
        // record water, test against max
        int result = 0;
        int curr = 0;
        while (l != r) {
            curr = findArea(height, l, r);
            if (curr > result) result = curr;
            if (height[l] > height[r]) r--;
            else {
                l++;
            }
        }
        // if at some point everything in between the pointers is less than the height of both pointers, stop
        return result;
    }

    public int findArea(int[] height, int l, int r) {
        return Math.min(height[l], height[r])*(r-l);
    }
}

/*
water = height * distance between heights
which two numbers in the arr have the greatest product of height min and distance



*/