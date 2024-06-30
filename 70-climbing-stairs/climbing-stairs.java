class Solution {
    public int climbStairs(int n) {
        // memoization cache
        ArrayList<Integer> cache = new ArrayList<>();
        // fill cache will -10 to indicate result has not been stored for given n
        for(int i = 0; i < 46; i++) cache.add(i, -10);
        return findTotal(n, cache);
    }

    public int findTotal(int n, ArrayList<Integer> cache) {
        // if we go below step 0, do not count as a distinct way
        if(n < 0) return 0;
        // if we reach 0, count as a valid distinct way
        else if(n == 0) return 1;
        // check cache for n
        else if(cache.get(n) != -10) return cache.get(n);

        // try going down one step, and two steps
        int result = findTotal(n-1, cache) + findTotal(n-2, cache);
        cache.add(n, result);
        return result;
    }
}
