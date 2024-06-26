class Solution {
    class TrieNode{
        TrieNode children[] = null;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
        public void insert(String key){
            TrieNode root = this;
             for(var chr : key.toCharArray()){
                int insertIndx = (chr - 'a');
                if(root.children[insertIndx] == null){
                    root.children[insertIndx] = new TrieNode();
                }
                root = root.children[insertIndx];
             }
             root.isEnd = true;           
        }
        public String find(String key){
            TrieNode root = this;
            StringBuilder res = new StringBuilder();
            for(var chr : key.toCharArray()){
                int insertIndx = (chr - 'a');
                if(root.children[insertIndx] == null){
                    break;
                }
                root = root.children[insertIndx];
                res.append(chr);
                if(root.isEnd){
                    return res.toString();
                }
             }
             return key;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(var word : dictionary){
            root.insert(word);
        }
        String words[] = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(var word : words){
            res.append(root.find(word));
            res.append(" ");
        }
        return res.toString().trim();
    }
}