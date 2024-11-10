class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int[] result = new int[2];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if the number has been recorded, add the next index in the list
            if(map.containsKey(nums[i])) {
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);
                map.put(nums[i], temp);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
           
        }

        Arrays.sort(nums);

        while(l < r) {
            if (nums[r] + nums[l] == target) {
                List<Integer> one = map.get(nums[l]);
                List<Integer> two = map.get(nums[r]);
                if(nums[r] == nums[l]) {
                    result[0] = one.get(0);
                    result[1] = two.get(1);
                }
                else {
                    result[0] = one.get(0);
                    result[1] = two.get(0);
                }
                
            }
            if (nums[r] + nums[l] > target) r--;
            else {
                l++;
            }
        }

        return result;
    }
}
/*
sort and go in two directions
2 7 11 15
2 3 4

*/