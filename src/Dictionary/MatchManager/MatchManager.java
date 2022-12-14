package Dictionary.MatchManager;

import Dictionary.MatchManager.Matcher.CharacterMatcher.CharacterMatcher;
//import Dictionary.MatchManager.Matcher.CharacterMatcher.DotMatcher;
import Dictionary.MatchManager.Matcher.CharacterMatcher.LetterMatcher;
import Dictionary.Trie.Trie;
import Dictionary.Trie.TrieNode;

import java.util.ArrayList;

public class MatchManager {

    private final ArrayList<CharacterMatcher> matchers;


    public MatchManager() {
        matchers = new ArrayList<>();
        matchers.add(new LetterMatcher());
        // matchers.add(new DotMatcher());
    }

    public void addMatcher(CharacterMatcher matcher) {
        matchers.add(matcher);
    }

    public ArrayList<String> match(String pattern, Trie wordTrie) {
        return new ArrayList<>();
    }
}
