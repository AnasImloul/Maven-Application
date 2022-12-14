import Dictionary.AlphabetMap.AlphabetArrayMap;
import Dictionary.AlphabetMap.AlphabetMap;
import Dictionary.Trie.WordTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hp\\Desktop\\modularity\\src\\Dictionary\\words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            System.err.println("There was a problem reading the file: " + e.getMessage());
        }

        AlphabetMap alphabetMapper = new AlphabetArrayMap();
        WordTrie wordTrie = new WordTrie(alphabetMapper);

        // WTrie wordTrie = new WTrie();

        double start = System.currentTimeMillis();
        for (String word : words) {wordTrie.insert(word);}
        double end = System.currentTimeMillis();

        System.out.println("Time taken to insert " + words.size() + " words: " + (end - start) + "ms");
        System.out.println("Size of trie: " + wordTrie.size());

        start = System.currentTimeMillis();
        for (String word : words) {wordTrie.contains(word);}
        end = System.currentTimeMillis();

        System.out.println("Time taken to search " + words.size() + " words: " + (end - start) + "ms");
        System.out.println("Size of trie: " + wordTrie.size());

        start = System.currentTimeMillis();
        for (String word : words) {wordTrie.remove(word);}
        end = System.currentTimeMillis();

        System.out.println("Time taken to remove " + words.size() + " words: " + (end - start) + "ms");
        System.out.println("Size of trie: " + wordTrie.size());
    }
}