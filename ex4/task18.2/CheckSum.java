import java.io.*;
public class CheckSum
{
  public static void main(String[] args)
  {
    int checkSum = 0;
    try
    {
      // defining variables
      int currentByte;
      // while the current byte is read in  and isn't the end of a file
      while((currentByte = System.in.read()) != -1)
      {
        // rotate checksum right
        if(checkSum % 2 == 0)
          checkSum /= 2;
        else
        { // rotate right checksum!
          checkSum /= 2;
          checkSum += 32768;
        }
        // checking if check sum is bigger than 16 bytes
        checkSum += currentByte;

        if (checkSum >= 65536)
          checkSum -= 65536;
      }     //while
    }
    catch(IOException exception)
    {
      System.out.println("Error: " + exception);
    } //catch
    finally
    {
      try{System.in.close();} // try
      catch (IOException exception)
        {
          System.err.println("Could not close input " + exception);
        } //catch
    }//try
    System.out.println(checkSum);
  }
}
