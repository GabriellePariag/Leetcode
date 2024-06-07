class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.get(arr[i]) != null) map.put(arr[i], map.get(arr[i])+1);
            else {
                map.putIfAbsent(arr[i], 0);
            }     
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> values = new ArrayList<>(map.values());
        for(int i = 0; i < values.size(); i++) {
            if(!set.add(values.get(i))) return false;
        }

        return true;  
    }
}