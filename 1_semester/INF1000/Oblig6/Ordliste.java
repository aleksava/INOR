//Importing the needed tools
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Ordliste {

  //Declaring ArrayList
  ArrayList<Ord> wordList= new ArrayList<>();

  //Reads all the words in a file and adds them to the list of the words
  //NB! a word should not appear multiple times
  public void lesBok(String filnavn) throws Exception {
    Scanner input = new Scanner(new File(filnavn));

    //Using a while-loop to run through the entire file
    while(input.hasNextLine()) {

      //Testing if the wordList is empty, and if it is then it adds the first
      //word of the book
      if (wordList.isEmpty()) {
        wordList.add(new Ord(input.nextLine()));
      }

      //Using the method leggTilOrd() to add the next word in the file
      leggTilOrd(input.nextLine());
    }
  }

  //Adds a new word to the wordlist, given it doesn't exists there allready
  //If the word allready exists, increase the amount by 1
  //NB! Ignore differences in capital and non-capital letters
  private void leggTilOrd(String ord) {
    String temporary = ord;

    //Using the method finnOrd to figure out whether or not the given word
    //allready exists in the wordlist. If it doesn't then it adds the word
    if (finnOrd(temporary) == null) {
      wordList.add(new Ord(temporary));
    }

    //If the word allready exists, then this part increases the amount of
    //times it appears
    else {
      finnOrd(temporary).oekAntall();
    }
  }

  //Finds and returns a given word in the dictionary, if the word doesn't
  //exists, then it returns null
  public Ord finnOrd(String tekst) {
    String temporary = tekst;

    //Running through the entire wordlist looking for a match, if it gets
    //a match then it returns the given word, if not it returns null
    for (int i = 0; i < wordList.size(); i++) {
      if (temporary.equalsIgnoreCase(wordList.get(i).toString())) {
        return wordList.get(i);
      }
    }
    return null;
  }

  //Figuers out how many times a given word appears in the dictionary, and
  //returns this
  public int antallForekomster(String tekst) {
    String temporary = tekst;
    return finnOrd(temporary).hentAntall();
  }

  //Finner ut og returnerer hvor mange ulike ord det finnes i ordlisten
  public int antallOrd() {
    return wordList.size();
  }

  //Finds and returns the most common word in the book. If there are
  //multiple words that are the most common, giving one of them is enough
  public Ord vanligste() {
    int mostCommon = 0;

    //Running through the entire wordlist and continuously updating the most
    //common word. 
    for (int i = 0; i < wordList.size(); i++) {
      if (wordList.get(i).hentAntall() > wordList.get(mostCommon).hentAntall()) {
        mostCommon = i;
      }
    }
    return wordList.get(mostCommon);
  }
}
