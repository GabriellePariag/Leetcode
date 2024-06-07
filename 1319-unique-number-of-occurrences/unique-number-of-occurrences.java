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

/*
map
1 -> 0 + 1 + 1 = 2
2 -> 0 + 1     = 1
3 -> 0         = 0

initialize each new key to 0
when key exists in map, add 1 to the value

create a set and add each value, if a conflict occurs, return false
*/