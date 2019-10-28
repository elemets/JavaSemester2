import java.util.ArrayList;
import java.awt.Color;


public class MagicWorker extends Worker
{

  ArrayList<MagicBall> magicWorkersBalls = new ArrayList<MagicBall>();

  int magicBallState = 0;

  public MagicWorker(String name)
  {
    super(name);
  }

  @Override
  public MagicWorkerImage makeImage()
  {
    return new MagicWorkerImage(this);
  }

  @Override
  public String getPersonType()
  {
    return "Magic Worker";
  }

  @Override
  public MagicBall makeNewBall(int number, Color color)
  {
    MagicBall magicBall1 = new MagicBall(number, color);
    magicWorkersBalls.add(magicBall1);
    return magicBall1;
  }

  public String getClassHierarchy()
  {
    return "MagicWorker" + super.getClassHierarchy();
  }



    public void doMagic(int spellNumber)
    {
      for (int magindex = 0; magindex < magicWorkersBalls.size(); magindex++)
      magicWorkersBalls.get(magindex).doMagic(spellNumber);
    }

}
