class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int max = 0;
        // add the entire arr to a set
        for(int num : nums) {
            if(num > max) max = num;
            set.add(num);
        }
        // go through set until number is found
        for(int i = 1; i < nums.length+1; i++) {
            if (!set.contains(i)) result.add(i);
        }

        return result;
    }
}
