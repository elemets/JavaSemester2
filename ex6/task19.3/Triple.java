public class Triple<FirstType, SecondType, ThirdType>
{
  // the first object
  private final FirstType first;

  // the second object
  private final SecondType second;

  // the third object
  private final ThirdType third;

  public Triple(FirstType requiredFirst, SecondType requiredSecond, ThirdType
  requiredThird)
  {
    first = requiredFirst;
    second = requiredSecond;
    third = requiredThird;
  }

  public FirstType getFirst()
  {
    return first;
  }

  public SecondType getSecond()
  {
    return second;
  }

  public ThirdType getThird()
  {
    return third;
  }

}
