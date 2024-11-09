class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        
        Set<Character> chars = new HashSet<>();
        int l = 0;
        int r = 1;
        int max = 0;

        chars.add(s.charAt(l));

        while(r < s.length() && l < s.length()) {
            if (!chars.contains(s.charAt(r))) {
                chars.add(s.charAt(r));
                r++;
            }
            else {
                System.out.println("duplicate found at index: " + r );
                while (!(s.charAt(l) == s.charAt(r))) {
                    chars.remove(s.charAt(l));
                    l++;
                }
                l++;
                r++;
            }
            
            System.out.println(chars);
            if (chars.size() > max) max = chars.size();
        }
        if (!(l == r)) {
            System.out.println("right has gone off");
            if (r-l > max) max = r-l;
        }
        
        return max;
    }
}

/*
"pwwkew"

if s.isEmpty, return 0
begin going through string with l and r pointer
l = 0 r = 1
add both to set if not equal to each other

move left without clearing set, move until duplicate value is found.
    if left is the duplicate value, simply move once
    else, move left till duplicate found, removing each char as u go
            move left once more

at the end of moving, set counter = current set length
find max



*/
