class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result = 0;

        // for each flowerbed spot
        for (int i = 0; i < flowerbed.length; i++) {
            // check if the spot is empty
            if(flowerbed[i] == 0) {
                // if empty, check if it is eligible
                if(checkEligible(flowerbed, i)) {
                    flowerbed[i] = 1;
                    result++;
                }
            }
        }

        if(result >= n) return true;
        else {
            return false;
        }
    }

    public boolean checkEligible(int[] flowerbed, int i) {
        if(flowerbed.length == 1) return true;
        else if(i == 0) {
            if(flowerbed[i+1] != 1) return true;
            else {
                return false;
            }
        }
        else if(i == (flowerbed.length-1)) {
            if(flowerbed[i-1] != 1) return true;
            else {
                return false;
            }
        }
        else {
            if((flowerbed[i-1] != 1) && (flowerbed[i+1] != 1)) return true;
            else {
                return false;
            }
        }
    }
}