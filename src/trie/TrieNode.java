package trie;

public class TrieNode {

    char val;
    TrieNode left, mid, right;
    boolean end;

    // Initialize your data structure here.
    public TrieNode() {
        // do nothing
    }

    public TrieNode(char val) {
        this.val = val;
    }
}
