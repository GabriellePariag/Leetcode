class Solution {
    public int fib(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);

        return helper(n, cache);
    }

    public int helper(int n, HashMap<Integer, Integer> cache) {
        if(cache.containsKey(n)) return cache.get(n);
        int result = helper(n-1, cache) + helper(n-2, cache);
        cache.put(n, result);
        return result;
    }
}