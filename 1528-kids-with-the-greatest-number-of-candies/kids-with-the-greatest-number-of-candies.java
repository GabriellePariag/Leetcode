class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        // loop through the kids and find the greatest int
        int greatest = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= greatest) greatest = candies[i];
        }
        // loop through again and if the sum > the greatest int, add true to array
        int sum;
        for (int i = 0; i < candies.length; i++) {
            if((candies[i] + extraCandies) >= greatest) result.add(true);
            else {
                result.add(false);
            }
        }

        return result;

    }
}