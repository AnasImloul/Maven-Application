package Dictionary.MatchManager.Matcher.CharacterMatcher;

import Dictionary.AlphabetMap.AlphabetMap;
import Dictionary.MatchManager.Pattern;

import java.util.ArrayList;

public class DotMatcher implements CharacterMatcher {

    @Override
    public char getCharacter() {
        return 0;
    }

    @Override
    public ArrayList<Character> nextLetters(Pattern pattern, AlphabetMap allowedLetters) {
        ArrayList<Character> nextLetters = allowedLetters.getKeys();
        pattern.next();
        return nextLetters;
    }

    @Override
    public boolean check(Pattern pattern) {
        return pattern.peek() == '.';
    }
}
