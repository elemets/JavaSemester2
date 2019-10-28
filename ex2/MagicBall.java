import java.awt.Color;
public class MagicBall extends Ball
{
  private static final int NORMAL = 0;
  private static final int INVISIBLE = 1;
  private static final int FLASHING = 2;
  private static final int FLASHCHANGE = 3;

  public int currentState = NORMAL;
  public int lastValue;

  public boolean isFlashing;
  public boolean isVisible;

  public MagicBallImage image;
  public int value;


// magic ball constructor
  public MagicBall (int requiredValue, Color requiredColor)
  {
    super(requiredValue, requiredColor);
    image = makeImage();
  }

@Override
  public MagicBallImage makeImage()
  {
    return new MagicBallImage(this);
  }


@Override
  public int getValue()
  {
    if (currentState == FLASHCHANGE)
    {
      if(value < 99)
      {
        lastValue = value;
        value++;
      }
      else
      value = 0;
      return lastValue;
    }
    else
    return super.getValue();
  }

  public void doMagic (int spellNumber)
  {
    if (spellNumber == 1)
      currentState = changeState(currentState);
    else if (spellNumber == 2)
      currentState = 0;
    this.getImage().update();
  }

  public boolean isVisible ()
  {
    if (currentState == NORMAL || currentState == FLASHING ||
                                  currentState ==  FLASHCHANGE)
      {
        this.getImage().update();
        return true;
      }
    else
    {
      this.getImage().update();
      return false;
    }
  }

  public boolean isFlashing ()
  {
    if(currentState == FLASHING || currentState == FLASHCHANGE)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public static int changeState(int currentState)
  {
    switch(currentState){
      case NORMAL:       return INVISIBLE;
      case INVISIBLE:    return FLASHING;
      case FLASHING:     return FLASHCHANGE;
      case FLASHCHANGE:  return NORMAL;
      default:           return currentState;
    }
  }

}
