import java.util.List;
import java.util.ArrayList;


public class MoodyGroup<PersonType extends MoodyPerson>
{

  public boolean isHappy;

  // Array list of moody people
  private List<MoodyPerson> moodyPeople = new ArrayList<MoodyPerson>();

  public MoodyGroup()
  {
  } // constructor

  public void setHappy(boolean isHappy)
  {
    for (MoodyPerson person : moodyPeople)
      person.setHappy(isHappy);
  } // set Happy

  public void addPersonMoody(MoodyPerson newPerson)
  {
    moodyPeople.add(newPerson);
  } // add Person Moody

  public String toString()
  {
    String result = moodyPeople.size() == 0 ? "" : "" + moodyPeople.get(0);
    for (int index =1; index < moodyPeople.size(); index++)
      result += String.format("%n%s", moodyPeople.get(index));
    return result;
  } // to string

}
