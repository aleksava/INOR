class Oblig6 {
  public static void main(String[] args) throws Exception {

    //Creating the wordlist, and also reading the given file.
    Ordliste list = new Ordliste();
    list.lesBok("scarlet.text");

    //Hvor mange ulike ord forekommer i boken?
    //Using the method antallOrd() to find the total amount of unique words
    System.out.println("\nThere are " + list.antallOrd() + " unique words in the book.");

    //Hvor mange ganger forekommer ordet "Holmes"?
    //Using the method antallForekomster() to find out how many times the word
    //'Holmes' appear in the text
    System.out.println("'Holmes' appear " + list.antallForekomster("Holmes") +
                        " time(s) in the text.");

    //Hvor mange ganger forekommer "elementary"?
    //Using the method antallForekomster() to find out how many times the word
    //'elementary' appear in the text
    System.out.println("'elementary' appear " + list.antallForekomster("elementary") +
                        " time(s) in the text.");

    //Hvilket ord forekommer flest ganger?
    //Using the method vanligste() and antallForekomster() on list.vanligste()
    //in order to find out which is the most common word, and also how many
    //times it appears
    System.out.println("The most common word in the text is '" +
                        list.vanligste().toString() + "' and it appears " +
                        list.antallForekomster(list.vanligste().toString()) + " times.\n");

  }
}
