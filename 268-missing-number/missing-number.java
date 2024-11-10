class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        // add the entire arr to a set
        for(int num : nums) {
            if(num > max) max = num;
            set.add(num);
        }
        // go through set until number is found
        for(int i = 0; i < nums.length+1; i++) {
            if (!set.contains(i)) return i;
        }

        return max++;
    }
}