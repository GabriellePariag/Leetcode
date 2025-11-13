class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int curr = k; // 8
        int result;
        boolean isOpposite = false;

        // i = 2
        for(int i = n; i > 2; i--) {
            int size = (int)Math.pow(2, i-1);
            result = transformRow(size, curr);
            if (result == 0) {
                curr = curr - size/2;
                System.out.println("row size: " + size + " curr pos: " + curr );
                if(isOpposite) isOpposite = false;
                else isOpposite = true;
            }
        }
        
        if(curr == 1) {
            if(isOpposite) return 1;
            return 0;
        }
        if(curr == 2) {
            if(isOpposite) return 0;
            return 1;
        }

        return 0;
    }

    public int transformRow(int size, int curr) {
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