package mypackage;

import java.util.ArrayList;

class Word extends SentenceElement {
    private ArrayList<Letter> letters;

    public Word(String someWord) {
        letters = splitToLetters(someWord);
    }

    private ArrayList<Letter> splitToLetters(String someWord) {
        ArrayList<Letter> letters = new ArrayList<>();
        char letter;
        for (int i = 0; i < someWord.length(); i++){
            letter = someWord.charAt(i);
            letters.add(new Letter(letter));
        }
        return letters;
    }

    public void filterLetters() {

        Letter lastLetter = letters.get(letters.size()-1);
        for (int i = 0; i < letters.size()-1;) {
            if(lastLetter.equals(letters.get(i))){
                letters.remove(i);
            }else{
                i++;
            }
        }

    }

    @Override
    public String toString() {
        String output = "";
        for (Letter l: letters){
            output += l;
        }
        return output;
    }
}
