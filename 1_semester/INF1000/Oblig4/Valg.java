import java.util.Scanner;
import java.io.File;

public class Valg {
  public static void main(String[] args) throws Exception {

    //Declaring variables and scanner
    Scanner votes = new Scanner(new File("stemmer.txt"));
    String votesArray [] = new String[456];
    int counter = 0;
    int votesAp = 0;
    int votesH = 0;
    int votesSp = 0;
    int votesKrF = 0;

    //Putting the votes into an array
    while(votes.hasNextLine()) {
      votesArray[counter] = votes.nextLine();
      counter ++;
    }

    //Counting the votes for each party
    counter = 0;
    while(counter < votesArray.length) {
      if(votesArray[counter].equals("Ap")) {
        votesAp ++;
      }
      else if(votesArray[counter].equals("H")) {
        votesH ++;
      }
      else if(votesArray[counter].equals("Sp")) {
        votesSp ++;
      }
      else if(votesArray[counter].equals("KrF")) {
        votesKrF ++;
      }
      counter ++;
    }

    System.out.println(votesAp + " " + votesSp + " " + votesH + " " + votesKrF);

    //Calculating percentages
    double votesTotal = (votesH + votesAp + votesSp + votesKrF);
    double votesApPercent = (votesAp/votesTotal)*100;
    double votesHPercent = (votesH/votesTotal)*100;
    double votesSpPercent = (votesSp/votesTotal)*100;
    double votesKrFPercent = (votesKrF/votesTotal)*100;

    //Announcing the winner (without cheating, reading the sourcecode)
    if(votesAp > votesH && votesAp > votesSp && votesAp > votesKrF) {
      System.out.print("The winner of the Bokn local election is Arbeiderpartiet! ");
      System.out.println("With a percentage of " + votesApPercent + "%\n");
    }
    else if(votesH > votesAp && votesH > votesSp && votesH > votesKrF) {
      System.out.print("The winner of the Bokn local election is Hoyre! ");
      System.out.println("With a percentage of " + votesHPercent + "%\n");
    }
    else if(votesSp > votesAp && votesSp > votesH && votesSp > votesKrF) {
      System.out.print("The winner of the Bokn local election is Senterpartiet! ");
      System.out.println("With a percentage of " + votesSpPercent + "%\n");
    }
    else {
      System.out.print("The winner of the Bokn local election is ");
      System.out.println("With a percentage of " + votesKrFPercent + "%\n");
    }
  }
}
