class TrieNode {
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    } 
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current_node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current_node.children[index] == null) {
                current_node.children[index] = new TrieNode();
            }
            current_node = current_node.children[index];
        }
        current_node.isWord = true;
    }
   
    public boolean search(String word) {
        TrieNode current_node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current_node.children[index] == null) return false;
            current_node = current_node.children[index];
        }
        return current_node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current_node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current_node.children[index] == null) return false;
            current_node = current_node.children[index];
        }
        return true;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // create a trie
        Trie trie = new Trie();
        // add all the words from dictionary to the trie
        for (String word : dictionary) {
            trie.insert(word);
        }

        StringBuilder curr = new StringBuilder(1000);
        StringBuilder result = new StringBuilder(1000);
        int marker = 0;
        
        for(int i = 0; i < sentence.length(); i++) {
            char letter = sentence.charAt(i);
            if (i+1 == sentence.length() && marker == 0) {
                curr.append(letter);
                result.append(curr);
            }
            else if (letter == ' ') {
                if (marker == 0) {
                    System.out.println(curr.toString());
                    result.append(curr);
                }
                result.append(letter);
                curr.delete(0, curr.length());
                marker = 0;
            }
            else if(marker != 1) {
                curr.append(letter);
                if(trie.search(curr.toString())){
                    marker = 1;
                    result.append(curr);
                    continue;
                }
            }
        }


        /*
        // split the sentence by the space, to get an array of strings
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // traverse the trie for a root for that string
            // for each node that matches the char, check for word end indicator
            // if indicator == 1, replace arr[i] with the root
        for (int i = 0; i < words.length; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                curr.append(words[i].charAt(j));
                if(trie.search(curr.toString())){
                    words[i] = curr.toString();
                    break;
                }
            }
            if (i+1 == words.length) result.append(words[i]);
            else result.append(words[i] + " ");
            
        }
        */

        return result.toString();
        
        
    }
}