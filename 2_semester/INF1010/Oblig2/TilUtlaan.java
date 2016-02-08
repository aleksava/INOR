/**The objects of all the classes that implements this interface will be able
*to borrow away this object to a given person recognized by a String. The
*object could also be returned.
*
*@author Aleksander Vaage
*version 8. february 2016
*/

interface TilUtlaan {

  /**
  *The method that borrows away the object to the given person recognized
  *by the String
  *
  *@param name The name of the loaner
  */
  public void borrowAway(String name);

  /**
  *Returns the object. The variable borrowedAway will be changed so that it's
  *clear that the object has been returned.
  */
  public void returnObject();
}
