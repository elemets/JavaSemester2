import java.io.*;

public class WordCount
{
  public static void main(String[] args)
  {
    InputStreamReader inputData = new InputStreamReader(System.in);
    try
    {
      int currentCharacter;
      int wordCount = 0;
      boolean previousSpaceWhite = false;

      while((currentCharacter = inputData.read()) != -1)
      {
        if(Character.isWhitespace(currentCharacter)
                      && previousSpaceWhite == true)
        {
          previousSpaceWhite = false;
          wordCount++;
        }
        else if((!Character.isWhitespace(currentCharacter))
                            && previousSpaceWhite == false)
        previousSpaceWhite = true;
      }
      // printing out word count
      System.out.println(wordCount);
    }
    catch(IOException exception)
    {
      // print out the exception
      System.out.println("Error: " + exception);
    }
    finally
    {
      try{ if (inputData != null) inputData.close();}
      catch (IOException exception)
        {
          System.err.println("Could not close input " + exception);
        }
    } // finally
  }
}
