package trie.problems;

import java.util.HashMap;
import java.util.Map;

//LeetCode 211. Design Add and Search Words Data Structure
public class WordDictionary {

    TrieNode root;

    private class TrieNode{

        private boolean isWord;
        private Map<Character, TrieNode> children;

        public TrieNode(){
            this.isWord = false;
            this.children = new HashMap<Character, TrieNode>();
        }

    }

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i)))
                curr.children.put(word.charAt(i), new TrieNode());
            curr = curr.children.get(word.charAt(i));
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    private boolean searchHelper(TrieNode node, int pos, String word) {

        if(pos == word.length())
            return node.isWord;

        if(node.children.size() == 0)
            return false;

        if(word.charAt(pos) == '.'){
            for(char c: node.children.keySet()){
                if(searchHelper(node.children.get(c), pos+1, word))
                    return true;
            }
        }

        if(!node.children.containsKey(word.charAt(pos)))
            return false;

        //if character at current position matches the node,
        //recursively search the remaining word
        return searchHelper(node.children.get(word.charAt(pos)), pos + 1, word);
    }
}
