package binary_tree;

public class ImplementTrie_208 {

    public static void main(String[] args) {

    }
}

class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()) {
            if(p.subNodes[c - 'a'] == null) {
                p.subNodes[c - 'a'] = new TrieNode();
            }
            p = p.subNodes[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()) {
            if(p.subNodes[c - 'a'] == null) return false;

            p = p.subNodes[c - 'a'];
        }

        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(char c : prefix.toCharArray()) {
            if(p.subNodes[c - 'a'] == null) return false;

            p = p.subNodes[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] subNodes;

    public TrieNode() {
        isEnd = false;
        subNodes = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
