package Dictionary.MatchManager.Matcher.CharacterMatcher;

import Dictionary.AlphabetMap.AlphabetMap;
import Dictionary.MatchManager.Pattern;

import java.util.ArrayList;


public interface CharacterMatcher {

    char getCharacter();

    ArrayList<Character> nextLetters(Pattern pattern, AlphabetMap allowedLetters);
    boolean check(Pattern pattern);
}
