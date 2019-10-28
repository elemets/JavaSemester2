public class TestRelativeDates
{
  public static void main(String[] args)
  {

    Date startDate;
    Date endDate;

      try
      {
      startDate = new Date("1/1/2019");
      endDate = new Date("1/1/2021");
      Date currentDate = startDate;
      while (!currentDate.equals(endDate)) {
        System.out.println("Reference:"+ currentDate);
        System.out.println(currentDate.addDay());
        System.out.println(currentDate.addMonth());
        System.out.println(currentDate.addYear());
        System.out.println(currentDate.subtractDay());
        System.out.println(currentDate.subtractMonth());
        System.out.println(currentDate.subtractYear());
        currentDate = currentDate.addDay();
      }
      }
      catch(Exception exception)
      {
        System.out.println("You got an exception!");
      }
  }
}
