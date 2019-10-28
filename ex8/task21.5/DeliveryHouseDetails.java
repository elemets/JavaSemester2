import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

public class DeliveryHouseDetails implements Comparable<DeliveryHouseDetails>
{

    int houseNumber;
    String personName;

    public DeliveryHouseDetails(int reqHouseNumber, String reqpersonName)
    {
        houseNumber = reqHouseNumber;
        personName = reqpersonName;
    }

    public int compareTo (DeliveryHouseDetails other)
    {
        if(other.houseNumber % 2 != 0 && houseNumber % 2 != 0)
            return this.houseNumber - other.houseNumber;
        else if(other.houseNumber % 2 == 0 && this.houseNumber % 2 == 0)
            return other.houseNumber - this.houseNumber;
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


    public String getHouse()
    {
        return houseNumber + " " + personName;
    }
}
