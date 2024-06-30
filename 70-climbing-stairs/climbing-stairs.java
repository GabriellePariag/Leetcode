class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> cache = new ArrayList<>();
        for(int i = 0; i < 46; i++) cache.add(i, -10);
        return findTotal(n, cache);
    }

    public int findTotal(int n, ArrayList<Integer> cache) {
        if(n < 0) return 0;
        else if(n == 0) return 1;
        else if(cache.get(n) != -10) return cache.get(n);
        int result = findTotal(n-1, cache) + findTotal(n-2, cache);
        cache.add(n, result);
        return result;
    }
}

/*
when n is reached, add one to return val
climbStairs(n-1);
climbStairs(n-2);

if (n < 0) return 0;
if (n == 0) return total++;
return climbStairs(n-1, total) + climbStairs(n-2, total)

add in memoization
index 1
store return value

*/