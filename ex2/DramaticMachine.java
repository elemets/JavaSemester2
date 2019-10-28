public class DramaticMachine extends Machine
{
  public DramaticMachine(String machineName, int machineSize)
  {
    super(machineName, machineSize);
  }

  public Ball ejectBall()
  {
    if(getNoOfBalls() <= 0)
      return null;
    else
    {
      int ejectedBallIndex = (int) (Math.random() * getNoOfBalls());
      Ball ejectedBall = getBall(ejectedBallIndex);

      for(int flashball = 0;  flashball <= ejectedBallIndex; flashball++)
      {
        Ball flashingBall = getBall(flashball);
        flashingBall.flash(4, 5);
      }

      swapBalls(ejectedBallIndex, getNoOfBalls() -1);
      removeBall();

      return ejectedBall;
    }
  }

  public String getType()
  {
    return "DramaticMachine";
  }


}
