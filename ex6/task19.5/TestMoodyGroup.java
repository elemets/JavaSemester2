public class TestMoodyGroup
{
  public static void main(String[] args) {
    // moody group of teenagers is called a flop
    MoodyGroup<Teenager> aFlop = new MoodyGroup<Teenager>();

    Teenager Jedwardio = new Teenager("Jedward");
    aFlop.addPersonMoody(Jedwardio);

    aFlop.addPersonMoody(new Teenager("Chelsea"));

    aFlop.addPersonMoody(new Teenager("Jay"));

    aFlop.setHappy(false);

    System.out.printf("%s%n%n", aFlop);

    aFlop.setHappy(true);

    System.out.printf("%s%n%n", aFlop);

    MoodyGroup<MoodyPerson> aFlopAChop = new MoodyGroup<MoodyPerson>();

    aFlopAChop.addPersonMoody(new Worker("Gary"));

     aFlopAChop.addPersonMoody(Jedwardio);

    aFlopAChop.setHappy(true);

    System.out.printf("%s%n%n", aFlopAChop);

    aFlopAChop.setHappy(false);

    System.out.printf("%s%n%n", aFlopAChop);

    System.out.printf("%s%n%n", aFlop);

  }

}
