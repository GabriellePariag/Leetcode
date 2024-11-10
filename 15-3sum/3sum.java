class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        int complement;

        for(int i = 0; i < nums.length; i++) {
            // if we have not yet seen this number, lets find its complement
            if (duplicates.add(nums[i])) {
                for (int j = i+1; j < nums.length; j++) {
                    // for each remaining number in the array
                    complement = -nums[i] - nums[j]; // this computes to zero
                    // do we have the final puzzle piece?
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        // success!
                        List<Integer> triplet = Arrays.asList(
                        nums[i],
                        nums[j],
                        complement
                        );
                        Collections.sort(triplet);
                        // add the sorted list to the set, since it is sorted, there will be no duplicates
                        res.add(triplet);
                    }
                    // finally, add this element to be used as a future complement
                    // as we move along the array
                    seen.put(nums[j], i);
                }
            }
        }

        return new ArrayList(res);
    }
}