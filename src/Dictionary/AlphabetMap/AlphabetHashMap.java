package Dictionary.AlphabetMap;

import Dictionary.Trie.TrieNode;

import java.util.*;

public class AlphabetHashMap implements AlphabetMap {
    private final HashMap<Character, TrieNode> children = new HashMap<>();

    @Override
    public AlphabetHashMap cloneEmpty() {
        return new AlphabetHashMap();
    }

    @Override
    public boolean isKeyValid(char key) {
        return key - 'a' >= 0 && key - 'z' <= 0;
    }

    @Override
    public boolean contains(char letter) {
        return false;
    }

    @Override
    public TrieNode get(char key) {
        return children.get(key);
    }

    @Override
    public TrieNode put(char key, TrieNode value) {
        TrieNode old = children.get(key);
        if (isKeyValid(key)) {
            return children.put(key, value);
        }
        return old;
    }

    @Override
    public TrieNode remove(char key) {
        return children.remove(key);
    }

    @Override
    public int size() {
        return children.size();
    }

    @Override
    public boolean isEmpty() {
        return children.isEmpty();
    }

    @Override
    public boolean containsKey(char key) {
        return children.containsKey(key);
    }

    @Override
    public boolean containsValue(TrieNode value) {
        return children.containsValue(value);
    }

    @Override
    public void clear() {
        children.clear();
    }

    @Override
    public Collection<TrieNode> getValues() {
        return children.values();
    }

    @Override
    public ArrayList<Character> getKeys() {
        return new ArrayList<>(children.keySet());
    }
}
