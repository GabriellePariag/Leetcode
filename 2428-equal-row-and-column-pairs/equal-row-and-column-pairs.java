class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for(int i = 0; i < grid.length; i++) {
            // add the column to the temp list
            for (int j = 0; j < grid.length; j++) {
                temp2.add(grid[i][j]);
                temp.add(grid[j][i]);
            }
            // map the row to the column
            map.put(i, new ArrayList<>(temp));
            temp.clear();
        }

        /*
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " ,Value: " + entry.getValue());
        }
        */

        // check for equal row and column pairs
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            list = Arrays.stream(grid[i]).boxed().collect(Collectors.toList());
            int freq = Collections.frequency(map.values(), list);
            result += freq;
            list.clear();
        }

        return result;
    }
}