class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // for each num in the arr
        for(int i = 0; i < arr.length; i++) {
            // add one to the value (occurences) if it exists in the map
            if(map.get(arr[i]) != null) map.put(arr[i], map.get(arr[i])+1);
            // put in map if absent, and set occurences to 0
            else {
                map.putIfAbsent(arr[i], 0);
            }     
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> values = new ArrayList<>(map.values());
        // iterate through all the values and find if they are distinct using a set
        for(int i = 0; i < values.size(); i++) {
            if(!set.add(values.get(i))) return false;
        }

        return true;  
    }
}