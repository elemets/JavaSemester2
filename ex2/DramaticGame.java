public class DramaticGame extends Game
{
  public DramaticGame(String machineName, int machineSize,
                          String rackname, int rackSize)
    {
      super(machineName, machineSize, rackname, rackSize);
    }


    public Machine makeMachine(String machineName, int machineSize)
    {
      return new DramaticMachine(machineName, machineSize);
    }
}
