class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++) {
            if(!set1.contains(nums2[i]) && !duplicates.contains(nums2[i])) set2.add(nums2[i]);
            else if(duplicates.contains(nums2[i])) continue;
            else {
                duplicates.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }

        List<Integer> result1 = new ArrayList<>(set1);
        List<Integer> result2 = new ArrayList<>(set2);
        List<List<Integer>> output = new ArrayList<>();
        output.add(result1);
        output.add(result2);
        return output;
    }
}
