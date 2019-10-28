public class DeliveryHouseDetails implements Comparable<DeliveryHouseDetails>
{

  int houseNumber;
  String personName_Number;

  public DeliveryHouseDetails(int reqHouseNumber, String reqPersonName_Number)
  {
    houseNumber = reqHouseNumber;
    personName_Number = reqPersonName_Number;
  }

  public int compareTo (DeliveryHouseDetails other)
  {
    if(other.houseNumber % 2 != 0 && houseNumber % 2 != 0)
      return houseNumber - other.houseNumber;
    else if(other.houseNumber % 2 == 0 && houseNumber == 0)
      return other.houseNumber - houseNumber;
    else if(houseNumber % 2 != 0)
      return -1;
    else
      return 1;
  }

  @Override
  public boolean equals (Object other)
  {
    if (other instanceof DeliveryHouseDetails)
      return houseNumber == ((DeliveryHouseDetails)other).houseNumber;
    else
      return super.equals(other);
  }


  public String getPersonName()
  {
    return personName_Number;
  }
}
