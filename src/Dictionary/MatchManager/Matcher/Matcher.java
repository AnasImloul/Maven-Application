package Dictionary.MatchManager.Matcher;

import Dictionary.MatchManager.Pattern;
import Dictionary.Trie.TrieNode;

import java.util.ArrayList;
import java.util.Collection;

public interface Matcher {

    MatcherType getType();
    boolean check(char letter);
    boolean check(Pattern pattern);
    Collection<Character> nextLetters(Pattern pattern, ArrayList<Character> allowedLetters, boolean checkAllowedLetters);
}

