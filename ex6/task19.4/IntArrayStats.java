public class IntArrayStats
{

  public static Triple<Integer, Integer, Double> getStats(int[] array)
  {
    if(array == null || array.length == 0)
      throw new IllegalArgumentException("Array must exist and be non-empty");



    // findin the maximum
    int maximumInteger = array[0];
    int maximumIndex = 0;
    int minimumInteger = array[0];
    int minimumIndex = 0;
    for(int index = 1; index < array.length; index++)
    {
      // finding the maximum
      if(maximumInteger < array[index])
      {
        maximumInteger = array[index];
        maximumIndex = index;
      }
      // finding the minimum
      if(minimumInteger > array[index])
      {
        minimumInteger = array[index];
        minimumIndex = index;
      }
    }



    double meanOfArray = 0;
    int arraySum = 0;
    for(int index = 0; index < array.length; index++)
    {
      arraySum += array[index];
      meanOfArray = arraySum / array.length;
    }

    return new Triple<Integer, Integer, Double>(maximumInteger, minimumInteger,
                                                meanOfArray);
  }




}
