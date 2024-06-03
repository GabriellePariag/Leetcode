class Solution {
    public String mergeAlternately(String word1, String word2) {
        String longest;
        String shortest;
        String result = "";

        // find the shortest word
        if(word1.length() > word2.length()) {
            longest = word1;
            shortest = word2;
        } else {
            longest = word2;
            shortest = word1;
        }

        for (int i = 0; i < longest.length(); i++) {
            if (i < shortest.length()) {
                // merge the strings alternately
                result += word1.charAt(i);
                result += word2.charAt(i);
            }
            // append remaining characters from longer word
            else {
                result += longest.charAt(i);
            }
        }

        return result;
    }
}