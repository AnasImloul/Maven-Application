package Dictionary.Trie;

import Dictionary.AlphabetMap.AlphabetMap;
import Dictionary.MatchManager.MatchManager;

import java.util.ArrayList;

public class WordTrie implements Trie {

    private final TrieNode root;

    private final MatchManager matchManager = new MatchManager();

    private final AlphabetMap alphabetMapper;

    public WordTrie(AlphabetMap alphabetMapper){
        this.alphabetMapper = alphabetMapper;
        root = new TrieNode(alphabetMapper);
    }

    @Override
    public TrieNode getRoot() {
        return root;
    }

    @Override
    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(!current.contains(letter)){
                current.put(letter, new TrieNode(alphabetMapper.cloneEmpty(), letter, false, current));
            }
            current = current.get(letter);
        }
        if(current.isEndOfWord){
            return;
        }
        current.isEndOfWord = true;
        while (current != null){
            current.increaseSize();
            current = current.getParent();
        }
    }

    @Override
    public boolean contains(String word){
        TrieNode current = getNode(word);
        return current != null && current.isEndOfWord;
    }

    @Override
    public void remove(String word){
        TrieNode current = getNode(word);

        if (current == null || !current.isEndOfWord){
            throw new IllegalArgumentException("Word does not exist in trie");
        }

        current.isEndOfWord = false;
        while (current != null){
            current.decreaseSize();
            if (current.size() == 0 && current.getParent() != null){
                current.getParent().remove(current.letter);
            }
            current = current.getParent();
        }
    }

    public int size(){
        return root.size();
    }

    public TrieNode getNode(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(!current.contains(letter)){
                return null;
            }
            current = current.get(letter);
        }
        return current;
    }

    public ArrayList<String> match(String word){
        return matchManager.match(word, this);
    }

}