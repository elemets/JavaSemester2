public class MeanMinMaxMinusMean
{
  public static void main(String[] args) {
    int[] array = new int[args.length];
    for(int index = 0; index < args.length; index++)
      array[index] = Integer.parseInt(args[index]);

    Triple stats = IntArrayStats.getStats(array);
    int max = ((Integer)stats.getFirst());
    int min = ((Integer)stats.getSecond());
    double mean = ((Double)stats.getThird());
    System.out.println((min + max) / 2.0 - mean);
  }

}
