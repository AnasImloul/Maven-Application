package Dictionary.Trie;

import Dictionary.AlphabetMap.AlphabetMap;

import java.util.ArrayList;

public class TrieNode {

    char letter;
    public AlphabetMap children;
    boolean isEndOfWord;
    private TrieNode parent;

    private int size;


    public TrieNode(AlphabetMap children, char letter, boolean isEndOfWord, TrieNode parent){
        this.children = children;
        this.letter = letter;
        this.isEndOfWord = isEndOfWord;
        this.parent = parent;
    }

    public TrieNode(AlphabetMap children, char letter, boolean isEndOfWord){
        this.children = children;
        this.letter = letter;
        this.isEndOfWord = isEndOfWord;
    }

    public TrieNode(AlphabetMap children, char letter){
        this.children = children;
        this.letter = letter;
        this.isEndOfWord = false;
    }

    public TrieNode(AlphabetMap children){
        this.children = children;
        this.letter = ' ';
        this.isEndOfWord = false;
    }

    public ArrayList<Character> getChildren(){
        return children.getKeys();
    }

    public boolean isEndOfWord(){
        return isEndOfWord;
    }


    public TrieNode getParent(){return parent;}

    public int size() { return size; }
    public void increaseSize(){
        size++;
    }

    public void decreaseSize(){
        size--;
    }


    public boolean contains(char letter) {
        return children.contains(letter);
    }

    public TrieNode get(char letter) {
        return children.get(letter);
    }

    public ArrayList<Character> getKeys() {
        return children.getKeys();
    }

    public void put(char letter, TrieNode object) {
        children.put(letter, object);
    }

    public void remove(char letter) {
        children.remove(letter);
    }
}
