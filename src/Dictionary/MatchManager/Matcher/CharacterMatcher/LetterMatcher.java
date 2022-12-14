package Dictionary.MatchManager.Matcher.CharacterMatcher;

import Dictionary.AlphabetMap.AlphabetMap;
import Dictionary.MatchManager.Pattern;

import java.util.ArrayList;

public class LetterMatcher implements CharacterMatcher {

    @Override
    public char getCharacter() {
        return 0;
    }

    @Override
    public ArrayList<Character> nextLetters(Pattern pattern, AlphabetMap current) {
        ArrayList<Character> nextLetters = new ArrayList<>();
        char nextLetter = pattern.peek();
        if (current.contains(nextLetter)) {
            nextLetters.add(nextLetter);
        }
        pattern.next();
        return nextLetters;
    }

    @Override
    public boolean check(Pattern pattern) {
        return pattern.peek() - 'a' >= 0 && pattern.peek() - 'z' <= 0;
    }
}
