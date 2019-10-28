public class Pair<FirstType, SecondType>
{
  // the first object
  private final FirstType first;

  // the second object
  private final SecondType second;


  public Pair(FirstType requiredFirst, SecondType requiredSecond)
  {
    first = requiredFirst;
    second = requiredSecond;
  }

  public FirstType getFirst()
  {
    return first;
  }

  public SecondType getSecond()
  {
    return second;
  }

}
