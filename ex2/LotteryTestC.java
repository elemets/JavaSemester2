import java.awt.Color;
public class LotteryTestC
{
  public static void main(String[] args)
  {
    SpeedController speedController
      = new SpeedController(SpeedController.HALF_SPEED);

    LotteryGUI gui = new LotteryGUI("TV Studio", speedController);

    Game game1 = new Game("Tester3", 4, "Slip and dip", 3);

    Worker worker1 = new TraineeWorker("Jim", 3);
    MagicBall magicBall1 = new MagicBall(4, Color.RED);


    gui.addGame(game1);
    game1.machineAddBall(magicBall1);
    worker1.fillMachine(game1);

  }
}
