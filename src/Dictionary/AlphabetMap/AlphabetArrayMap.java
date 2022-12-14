package Dictionary.AlphabetMap;

import Dictionary.Trie.TrieNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AlphabetArrayMap implements AlphabetMap {

    private TrieNode[] children = new TrieNode[ALPHABET_COUNT];
    int size = 0;


    @Override
    public AlphabetMap cloneEmpty() {
        return new AlphabetArrayMap();
    }

    @Override
    public boolean isKeyValid(char key) {
        return key - 'a' >= 0 && key - 'z' <= 0;
    }

    @Override
    public ArrayList<Character> getKeys() {
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (children[i] != null) {
                result.add((char) (i + 'a'));
            }
        }
        return result;
    }

    @Override
    public boolean contains(char letter) {
        return children[letter - 'a'] != null;
    }

    @Override
    public TrieNode get(char key) {
        return children[key - 'a'];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(char key) {
        int index = (int) key - 'a';
        if (index < 0 || index >= ALPHABET_COUNT) {
            return false;
        }
        return children[index] != null;
    }

    @Override
    public boolean containsValue(TrieNode value) {
        for (TrieNode child : children) {
            if (child == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TrieNode put(char key, TrieNode value) {
        int index = (int) key - 'a';
        if (index < 0 || index >= ALPHABET_COUNT) {
            return null;
        }
        TrieNode old = children[index];
        children[index] = value;
        if (old == null) {
            size++;
        }
        return old;
    }

    @Override
    public TrieNode remove(char key) {
        int index = (int) key - 'a';
        if (index < 0 || index >= ALPHABET_COUNT) {
            return null;
        }
        TrieNode old = children[index];
        children[index] = null;
        if (old != null) {
            size--;
        }
        return old;
    }

    @Override
    public void clear() {
        children = new TrieNode[ALPHABET_COUNT];
        size = 0;
    }

    @Override
    public Collection<TrieNode> getValues() {
        ArrayList<TrieNode> list = new ArrayList<>();
        for (TrieNode child : children) {
            if (child != null) {
                list.add(child);
            }
        }
        return list;
    }
}