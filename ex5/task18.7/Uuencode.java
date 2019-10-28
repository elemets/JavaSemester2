import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


// program to turn images into acii characters
public class Uuencode
{
  static FileInputStream inputFile = null;

  public static void main(String[] args) throws IOException,
  IllegalArgumentException
  {

    String fileName = args[0];

    if(args.length != 1)
      throw new IllegalArgumentException();

    System.out.println("Uuencode-Mode -- file mode is 600 " + fileName);

    try
    {
    inputFile = new FileInputStream(fileName);

    int MAX_ARRAY_SIZE = 45;

    int[] lineBytes = new int[MAX_ARRAY_SIZE];

    int nextByteToRead = inputFile.read();

    while(nextByteToRead != -1)
      {
        int lineSize = 0;
        while(nextByteToRead != -1 && lineSize < lineBytes.length)
        {
          lineBytes[lineSize] = nextByteToRead;
          nextByteToRead = inputFile.read();
          lineSize++;
        }
      writeByteAsChar(lineSize);
      for(int index = 0; index < lineSize; index += 3)
      {
        int byte1 = lineBytes[index] >> 2;
        int byte2 = (lineBytes[index] & 0x3) << 4 | (lineBytes[index + 1] >> 4);
        int byte3 = (lineBytes[index + 1] & 0xf) << 2
                              | lineBytes[index + 2] >> 6;
        int byte4 = lineBytes[index + 2] & 0x3f;

        writeByteAsChar(byte1);
        writeByteAsChar(byte2);
        writeByteAsChar(byte3);
        writeByteAsChar(byte4);
      }
      System.out.println();
    }
    writeByteAsChar(0);
    System.out.println();
    System.out.println("end");
  }
  catch(DateException exception)
  {
    System.out.println("You have caused a Date exception!");
  }
  catch(FileNotFoundException exception)
  {
    System.out.println("Can't seem to find your file!");
    System.err.println(exception);
  } finally {
    try {
      if (inputFile != null) {
        inputFile.close();
      }
    } catch (IOException e) {
      System.out.println("Oh no its an IO Exception");
      System.err.print(e);
    }
  }
}


  private static void writeByteAsChar(int thisByte)
  {
    System.out.print((char) (thisByte == 0 ? 96 : thisByte + 32));
  }
}
