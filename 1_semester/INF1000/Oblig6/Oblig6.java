class Oblig6 {
  public static void main(String[] args) throws Exception {
    Ordliste list = new Ordliste();
    list.lesBok("scarlet.text");
    int test = list.antallForekomster("elementary");

    //Hvor mange ulike ord forekommer i boken?
    System.out.println("\nThere are " + list.antallOrd() + " unique words in the book.");

    //Hvor mange ganger forekommer ordet "Holmes"?
    System.out.println("'Holmes' appear " + list.antallForekomster("Holmes") +
                        " times in the text.");

    //Hvor mange ganger forekommer "elementary"?
    System.out.println("'elementary' appear " + test +
                        " times in the text.");

    //Hvilket ord forekommer flest ganger?
    System.out.println("The most common word in the text is '" +
                        list.vanligste().toString() + "' and it appears " +
                        list.antallForekomster(list.vanligste().toString()) + " times.\n");
    
  }
}
