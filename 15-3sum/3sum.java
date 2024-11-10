class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        int complement;

        for(int i = 0; i < nums.length; i++) {
            if (duplicates.add(nums[i])) {
                for (int j = i+1; j < nums.length; j++) {
                    complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(
                        nums[i],
                        nums[j],
                        complement
                        );
                        Collections.sort(triplet);
                        // add the set to the map, and its actual list. so there are no repeats.
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }

        return new ArrayList(res);
    }
}