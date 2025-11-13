class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int curr = k;
        int result;
        boolean isOpposite = false;

        for(int i = n; i > 2; i--) {
            int size = (int)Math.pow(2, i-1); // rows double in size per ea new row
            result = checkSide(size, curr);

            // if we need to switch sides
            if (result == 0) {
                // calculate new index on left side that is equiv as right side positioning
                curr = curr - size/2;
                // if already flagged, turn it off
                if(isOpposite) isOpposite = false;
                else isOpposite = true;
            }

            // otherwise, do nothing. the index is good and we can move up a row
        }
        
        // once we are on row 2, with just 2 choices, find the matching symbol
        if(curr == 1) {
            if(isOpposite) return 1; // account for opposite flag
            return 0;
        }
        if(curr == 2) {
            if(isOpposite) return 0;
            return 1;
        }

        return 0;
    }

    // checks if index is on the right or left side of the row
    public int checkSide(int size, int curr) {
        if(curr > size/2) return 0; // 0 means opposite int on left side
        else return 1; // 1 means same int as it currently is
    }

    /*
    the row will double in size with each new row
    to predict the kth symbol, first find the total size of row n
    row 1 size = 1, row 2 size = 2
    from there row n to the power of 2
    row n size = 2^n-1

    12th = 1
    0
    0 1
    01 10
    0110 1001

    if number is on right half, it is opposite the same position on the left half
    go to left half, and go up recursively until we have determined the symbol
    */
}