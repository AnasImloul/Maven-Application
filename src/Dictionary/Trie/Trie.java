package Dictionary.Trie;

public interface Trie {

    void insert(String word);
    void remove(String word);
    boolean contains(String word);

    TrieNode getRoot();
}

