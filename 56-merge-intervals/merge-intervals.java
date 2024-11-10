class Solution {
    public int[][] merge(int[][] intervals) {
        boolean overlap = false;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < intervals.length; i++) {
            List<Integer> list;
            List<Integer> list2;
            if(i+1 < intervals.length && intervals[i][1] >= intervals[i+1][0]) overlap = true;
            else if(i+1 < intervals.length && intervals[i][0] == intervals[i+1][0]) overlap = true;

            if(overlap == true){
                System.out.println("overlap found between" + intervals[i][0] + "," + intervals[i][1] + "and " + intervals[i+1]);
                int[] merged = doMerge(intervals[i], intervals[i+1]);
                list = Arrays.stream(merged).boxed().collect(Collectors.toList());
                list2 = Arrays.stream(intervals[i]).boxed().collect(Collectors.toList());
                intervals[i+1] = merged;
                result.remove(list2);
                overlap = false;
            }
            else {
                list = Arrays.stream(intervals[i]).boxed().collect(Collectors.toList());
            }
            result.add(list);
        }

        int j = 0;
        int[][] output = new int[result.size()][2];
        for(List<Integer> list : result) {
            output[j][0] = list.get(0).intValue();
            output[j][1] = list.get(1).intValue();
            j++;
        }
        return output;
    }

    public int[] doMerge(int[] one, int[] two) {
        int[] result = new int[2];
        result[0] = Math.min(one[0], two[0]);
        result[1] = Math.max(one[1], two[1]);
        return result;
    }

    public void sortArr(int[][] arr) {
    }
}

/*
sort the intervals by start
go through the list
    if end interval >= next start interval, flag overlap
    if start interval == next start interval, flag overlap

    if flag overlap
        combine()

def combine
take min of starts, add to arr[]
take max of ends, add to arr[]
return arr

[1, 5]
*/