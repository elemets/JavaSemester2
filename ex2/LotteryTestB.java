 public class LotteryTestB
 {
   public static void main(String[] args) {
     SpeedController speedController
       = new SpeedController(SpeedController.HALF_SPEED);

     LotteryGUI gui = new LotteryGUI("TV Studio", speedController);

     Game game1 = new DramaticGame("Lott O'Luck Larry", 49,
                           "Slippery's Mile", 7);

    gui.addGame(game1);
    Worker worker1 = new TraineeWorker("Jim", 0);
    gui.addPerson(worker1);
    worker1.fillMachine(game1);
    speedController.delay(40);

    for (int count = 1; count <= game1.getRackSize(); count ++)
    {
      game1.ejectBall();
    }


    game1.rackSortBalls();
    speedController.delay(40);



   }
 }
