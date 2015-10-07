import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Ordliste {

  //Declaring filereader, arraylist and so on.
  File test = new File("scarlet.text");
  ArrayList<Stuff> wordList= new ArrayList<>();

  //Reads all the words in a file and adds them to the list of the words
  //NB! a word should not appear multiple times
  public void lesBok(String filnavn) throws Exception {

  }

  //Adds a new word to the wordlist, given it doesn't exists there allready
  //If the word allready exists, increase the amount by 1
  //NB! Ignore differences in capital and non-capital letters
  private void leggTilOrd(String ord) {

  }

  //Finds and returns a given word in the dictionary, if the word doesn't
  //exists, then it returns null
  public Ord finnOrd(String tekst) {

  }

  //Figuers out how many times a given word appears in the dictionary, and
  //returns this
  public int antallForekomster(String tekst) {

  }

  //Finds and returns the most common word in the book. If there are
  //multiple words that are the most common, giving one of them is enough
  public Ord vanligste() {

  }
}
