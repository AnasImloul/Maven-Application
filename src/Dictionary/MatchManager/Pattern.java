package Dictionary.MatchManager;

import Dictionary.MatchManager.Matcher.CharacterMatcher.CharacterMatcher;
import Dictionary.MatchManager.Matcher.Matcher;
import Dictionary.MatchManager.Matcher.MatcherType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Pattern implements Cloneable {
    private LinkedList<Character> pattern;
    private Collection<Character> allowedLetters;
    private Collection<Matcher> matchers = new ArrayList<>();

    public Pattern(String pattern, Collection<Character> allowedLetters) {
        this.pattern = new LinkedList<>();
        int index = 0;
        while (index < pattern.length()){
            for (Matcher matcher : matchers) {
                if (matcher.check(pattern.charAt(index))){
                    if (matcher.getType() == MatcherType.COLLECTION){
                        ArrayList<Character> letters = new ArrayList<>();
                        allowedLetters.addAll(matcher.nextLetters(this, new ArrayList<>(), false));
                    }
                    else {
                        this.pattern.add(pattern.charAt(index));
                    }
                }
            }
            this.pattern.add(pattern.charAt(index));
            index++;
        }
    }

    public char peek(){
        return pattern.peek();
    }

    public char next(){
        return pattern.pop();
    }

    public boolean hasNext(){ return !pattern.isEmpty(); }

    public boolean check(char c){
        return pattern.peek() == c;
    }

    @Override
    public Pattern clone() {
        // Pattern clone = new Pattern("");
        // clone.pattern = (LinkedList<Character>) this.pattern.clone();
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Character c : pattern) {
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return pattern.isEmpty();
    }
}
