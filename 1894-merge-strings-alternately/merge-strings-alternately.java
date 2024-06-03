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

        for (int i = 0; i < shortest.length(); i++) {
            // merge the strings alternately
            result += word1.charAt(i);
            result += word2.charAt(i);
        }

        // if the word lengths are not equal
        if (longest.length() > shortest.length()) {
            // append the remaining characters
            for (int j = shortest.length(); j < longest.length(); j++) {
                result += longest.charAt(j);
            }
        }

        return result;
    }
}