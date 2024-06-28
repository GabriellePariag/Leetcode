class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(i, s.substring(i, i+1));
        }

        for(int i = 0; i < indices.length; i++) {
            if(checkForReplace(s, indices[i], sources[i])) {
                map.put(indices[i], targets[i]);
                if(sources[i].length() > 1) {
                    for(int j = 1; j < sources[i].length(); j++) {
                        map.put(indices[i]+j, "");
                    }
                }   
            } 
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < map.size(); i++) {
            builder.append(map.get(i));
        }

        return builder.toString();
    }

    public boolean checkForReplace(String s, int index, String source) {
        if(source.length() > s.length()-index) return false;
        for(int i = 0; i < source.length(); i++) {
            if(!(s.charAt(index+i) == source.charAt(i))) return false;
        }

        return true;
    }

}
/* 
how do we do this simultaneously?

hashmap?
0 a
1 b
2 c
3 d

check function (indice, source, string)
    for(length of source)
        if !(string[indice+i] = source[i]) return false
    
    return true

run check function for k num of times

if true, lookup indice in hashmap
replace value for that indice with new source
0 eee
1 b
2 ffff
3 d

to remedy the problem of remaining characters, for length of source-1, replace the next x keys with ""
                                                                1                indice 2+1 = 3
0 eee
1 b
2 ffff
3 
*/