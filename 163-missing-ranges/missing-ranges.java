class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ranges = new ArrayList<List<Integer>>();

        int left = 0;
        int right = 1;

        // edge case for empty arr
        if (nums.length == 0) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(lower);
            l.add(upper);
            ranges.add(l);
            return ranges;
        }

        // edge case for lower bound
        if (nums[left] != lower) {
            List<Integer> r = new ArrayList<Integer>();
            r.add(lower);
            r.add(nums[left]-1);
            ranges.add(r);
        }

        for (int i = 0; i < nums.length; i++) {
            // edge case for upper bound
            if(left == nums.length-1) {
                if(nums[left] != upper) {
                    List<Integer> s = new ArrayList<Integer>();
                    s.add(nums[left]+1);
                    s.add(upper);
                    ranges.add(s);
                }

                break;
            }

            if(!checkSequential(nums[left], nums[right])) {
                List<Integer> n = new ArrayList<Integer>();
                n.add(nums[left]+1);
                n.add(nums[right]-1);
                ranges.add(n);
            }

            left++;
            right++;
        }

        return ranges;
    }

    public boolean checkSequential(int left, int right) {
        if(left+1 == right) return true;
        return false;
    }
}

/*
two pointer solution
0, 1, 3, 50, 75   lower = 0, upper = 99
      *  *

on first index, check if equal to lower bound
    if no, then return [lower bound, first_index - 1]

check if they are sequential
    if no, find range
    then move both pointers forward

how to find range
    3-1 = 2 if range == 2, we're missing a single number, return [2, 2]
    50-3 = 47, do 3+1 = 4 and 50-1 = 49, return [4, 49]
    75-50 = 15, do 50+1 = 51 and 75-1 = 74, return [51, 74]

if right pointer is on last index, find range to upper bound

*/