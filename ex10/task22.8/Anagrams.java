// Outputting all permutations of a string

public class Anagrams
{

  public static char[] anagramArray;
  public static char[] currentPermutation;
  public static boolean[] hasCharBeenUsed;
  public static int anagramArrayLength;

  public static void main(String[] args)
  {
      String toBeAnagrammed = args[0];

      // creating a char array out of the string
      anagramArray = toBeAnagrammed.toCharArray();

      // setting up another array to build current permutation
      currentPermutation = new char[anagramArray.length];

      // setting up another array to see whether the last character has been
      // used
      hasCharBeenUsed = new boolean[anagramArray.length];

      // calling recursive method to create all the permuations

      printPermutations(0);

  }

  public static void printPermutations(int currentIndex)
  {
    // if the current index has gone past the length of the current permutation
    // then print out the permutation
    if(currentIndex == currentPermutation.length)
      System.out.println(new String(currentPermutation));
    else
    { // for current Index less than the anagram array
      for(int index = 0; index < anagramArray.length; index++)
      {
        // check if the current char has been used if it hasn't
        if(hasCharBeenUsed[index] == false)
        {
          // set it as being used
          hasCharBeenUsed[index] = true;
          // then set it in the current permutation array
          currentPermutation[currentIndex] = anagramArray[index];
          printPermutations(currentIndex + 1);
          hasCharBeenUsed[index] = false;
        }
      }
    }
  }
}
