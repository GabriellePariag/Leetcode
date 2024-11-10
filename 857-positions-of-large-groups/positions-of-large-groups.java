class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        // iterate through string, if char is the same as next, add to counter
        // if it is not the same as next, add to counter and if counter>3, store in list
        List<List<Integer>> result = new ArrayList<>();
        int counter = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            // once we reach the end, check if the char is part of a group
            if (i+1 >= s.length()) {
                counter++;
                if (counter >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i);
                    result.add(list);
                }
            }
            else if(s.charAt(i) == s.charAt(i+1)){
                counter++;
            }
            else {
                counter++;
                if (counter >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i);
                    result.add(list);
                }

                start = i+1;
                counter = 0;
            }
        }

        return result;
    }
}