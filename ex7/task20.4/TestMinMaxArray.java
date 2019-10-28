public class TestMinMaxArray <ArrayType>
{
  public static void main(String[] args)
  {
    String[] array = new String[args.length];

    // get the values from args

    for(int index = 0; index < args.length; index++)
      array[index] = args[index];

    Pair<String, String> stats = MinMaxArray.minMax(array);
    String max = stats.getFirst();
    String min = stats.getSecond();

    System.out.println(max);
  }
}
