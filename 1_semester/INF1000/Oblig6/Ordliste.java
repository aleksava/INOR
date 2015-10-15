import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Ordliste {

  //Declaring filereader, arraylist and so on.
  ArrayList<Ord> wordList= new ArrayList<Ord>();

  //Reads all the words in a file and adds them to the list of the words
  //NB! a word should not appear multiple times
  public void lesBok(String filnavn) throws Exception {
    String temporary = "hei";
    Scanner input = new Scanner(new File(filnavn));



    while(input.hasNextLine()) {
      //System.out.println("while");
      //Testing if the wordList is empty, and if it is then it adds the first
      //word of the book
      if (wordList.isEmpty()) {
        wordList.add(new Ord(input.nextLine()));
        System.out.println(wordList.subList(0,1));
      }
      leggTilOrd(input.nextLine());
    }
    System.out.println(wordList.subList(0,20));
  }

  //Adds a new word to the wordlist, given it doesn't exists there allready
  //If the word allready exists, increase the amount by 1
  //NB! Ignore differences in capital and non-capital letters
  public void leggTilOrd(String ord) {
    String temporary = ord;

    if (finnOrd(temporary) == null) {
      wordList.add(new Ord(temporary));
    }
    else {
      finnOrd(temporary).oekAntall();
    }
  }

  //Finds and returns a given word in the dictionary, if the word doesn't
  //exists, then it returns null
  public Ord finnOrd(String tekst) {
    String temporary = tekst;

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

  public int antallOrd() {
    return wordList.size();
  }

  //Finds and returns the most common word in the book. If there are
  //multiple words that are the most common, giving one of them is enough
  public Ord vanligste() {
    int mostCommon = 0;
    for (int i = 0; i < wordList.size(); i++) {
      if (wordList.get(i).hentAntall() > wordList.get(mostCommon).hentAntall()) {
        mostCommon = i;
      }
    }
    return wordList.get(mostCommon);
  }
}
