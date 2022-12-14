package Dictionary.AlphabetMap;

import Dictionary.Trie.TrieNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface AlphabetMap {

    final int ALPHABET_COUNT = 26;

    AlphabetMap cloneEmpty();

    boolean isKeyValid(char key);

    boolean contains(char letter);

    TrieNode get(char key);

    TrieNode put(char key, TrieNode value);

    TrieNode remove(char key);

    void clear();

    int size();

    boolean isEmpty();

    boolean containsKey(char key);

    boolean containsValue(TrieNode value);

    Collection<TrieNode> getValues();

    ArrayList<Character> getKeys();
}
