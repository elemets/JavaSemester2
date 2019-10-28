public class LotteryTestD
{
  public static void main(String[] args) {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI("TV Studio", speedController);



    MagicWorker magicWorker1 = new MagicWorker("Joe");
    MagicWorker magicWorker2 = new MagicWorker("Todd");
    gui.addPerson(magicWorker1);
    gui.addPerson(magicWorker2);

    Game game1 = new Game("MagicWorkerTest", 4, "Slip and dip", 4);
    Game game2 = new Game("MagicWorkerTest2", 4, "nip and whip", 5);

    gui.addGame(game1);
    gui.addGame(game2);

    magicWorker1.fillMachine(game1);
    magicWorker2.fillMachine(game2);

    for (int count = 1; count <= game1.getRackSize(); count ++)
    {
      game1.ejectBall();
    }

    for (int count = 1; count <= game2.getRackSize(); count ++)
    {
      game2.ejectBall();
    }

  }
}
