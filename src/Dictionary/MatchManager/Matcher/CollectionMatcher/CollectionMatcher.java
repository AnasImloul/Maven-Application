package Dictionary.MatchManager.Matcher.CollectionMatcher;

import Dictionary.MatchManager.Matcher.Matcher;
import Dictionary.MatchManager.Pattern;

import java.util.Collection;

public interface CollectionMatcher extends Matcher {
    boolean checkOpened(char letter);
    boolean checkOpened(Pattern pattern);
    boolean checkClosed(char letter);
    boolean checkClosed(Pattern pattern);
    boolean checkSeparator(char letter);
    boolean checkSeparator(Pattern pattern);
    Collection<Character> getLetters(Pattern pattern);
}
