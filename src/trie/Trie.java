package trie;

/*
LeetCode 208. Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure
used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie
(i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted
string word that has the prefix prefix, and false otherwise.

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

* */

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean search(String word) {
        if(word == null || word.isEmpty())
            return false;
        return search(word, 0, root);
    }

    //ternary search
    public boolean search(String word, int index, TrieNode node) {
        if (node == null)
            return false;

        char c = word.charAt(index);

        if(c<node.val)
            return search(word, index, node.left);

        else if(c>node.val)
            return search(word, index, node.right);

        else if(index<word.length()-1)
            return search(word, index+1, node.mid);

        else
            return node.end;
    }

    public void insert(String word) {
        if (word != null && !word.isEmpty())
            insert(word, 0, root);
    }

    private TrieNode insert(String word, int index, TrieNode node) {
        char c = word.charAt(index);
        if(node == null)
            node=new TrieNode(c);

        if(c<node.val)
            node.left=insert(word, index, node.left);

        else if(c>node.val)
            node.right=insert(word, index, node.right);

        else if(index<word.length()-1)
            node.mid = insert(word, index+1, node.mid);

        else node.end = true;

        return node;
    }

    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.isEmpty())
            return false;

        return startsWith(prefix, 0, root);
    }

    private boolean startsWith(String prefix, int index, TrieNode node){
        if(node == null)
            return false;

        char c = prefix.charAt(index);

        if(c<node.val)
            return startsWith(prefix, index, node.left);

        else if(c>node.val)
            return startsWith(prefix, index, node.right);

        else if (index == prefix.length() - 1)
            return true;

        else
            return startsWith(prefix, index + 1, node.mid);
    }
}
