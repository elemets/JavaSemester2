import java.util.Arrays;

public class MinMaxArray
{
  public static <ArrayType extends Comparable<ArrayType>> Pair<ArrayType, ArrayType> minMax(ArrayType[] anArray)
  throws IllegalArgumentException
  {
    ArrayType maximum = anArray[0];
    ArrayType minimum = anArray[0];

    try
    {

      for(int index = 0; index < anArray.length; index++)
      {
      // finding the maximum
      if(maximum.compareTo(anArray[index]) < 0)
        maximum = anArray[index];

      // finding the minimum
      if(minimum.compareTo(anArray[index]) > 0)
        minimum = anArray[index];
      } // for

    } // try
    catch(IllegalArgumentException e)
    {
      System.out.println("The argument was wrong try again");
    } // catch

    return new Pair<ArrayType, ArrayType>(maximum, minimum);
  } // minMax
} // class MinMaxArray
