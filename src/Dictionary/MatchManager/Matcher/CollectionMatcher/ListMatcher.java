package Dictionary.MatchManager.Matcher.CollectionMatcher;

import Dictionary.MatchManager.Matcher.MatcherType;
import Dictionary.MatchManager.Pattern;

import java.util.ArrayList;
import java.util.Collection;

public class ListMatcher implements CollectionMatcher{
    @Override
    public boolean checkOpened(char letter) {
        return letter == '[';
    }

    @Override
    public boolean checkOpened(Pattern pattern){
        return checkOpened(pattern.peek());
    }

    @Override
    public boolean checkClosed(char letter) {
        return letter == ']';
    }

    @Override
    public boolean checkClosed(Pattern pattern){
        return checkClosed(pattern.peek());
    }

    @Override
    public boolean checkSeparator(char letter) {
        return letter == ',';
    }

    @Override
    public boolean checkSeparator(Pattern pattern) {
        return checkSeparator(pattern.peek());
    }

    @Override
    public Collection<Character> getLetters(Pattern pattern) {
        Collection<Character> result = new ArrayList<>();
        if (!checkOpened(pattern)){
            throw new IllegalArgumentException("Can't get allowed letters if you are not on a opened bracket.");
        }
        pattern.next();
        boolean lastSeparator = true;
        while (!checkClosed(pattern)){
            if (lastSeparator){
                if (checkSeparator(pattern)){
                    throw new IllegalArgumentException("Can't have a separator in the start of the list or two separators next to each other");
                }
                lastSeparator = false;
                result.add(pattern.peek());
                pattern.next();
                continue;
            }
            if (!checkSeparator(pattern)){
                throw new IllegalArgumentException("can't have two characters next to each other");
            }
            lastSeparator = true;
            pattern.next();
        }
        return result;
    }

    @Override
    public MatcherType getType() {
        return MatcherType.COLLECTION;
    }

    @Override
    public boolean check(char letter) {
        return checkOpened(letter);
    }

    @Override
    public boolean check(Pattern pattern) {
        return checkOpened(pattern);
    }

    @Override
    public Collection<Character> nextLetters(Pattern pattern, ArrayList<Character> allowedLetters, boolean checkAllowedCharacters) {
        return getLetters(pattern);
    }
}
