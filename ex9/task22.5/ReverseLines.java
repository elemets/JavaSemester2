import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class ReverseLines
{

  public static BufferedReader input = null;
  public static PrintWriter output =  null;



  public static void main(String[] args) throws Exception
  {

    try
    {
    input = new BufferedReader(new FileReader(args[0]));
    output = new PrintWriter(new FileWriter(args[1]));

    // if reading the first line does not return null means the file
    // is not empty

    recursiveOutput(input, output);

    }
    catch(IOException e) {System.out.println("IO Exception caught!!");}
    finally { try { if(input != null)input.close();}
    catch (IOException exception)
      {  System.err.println("Could not close input " + exception);   }
          if (output != null)
          {
            output.close();
              if (output.checkError())
                System.err.println("something went wrong with the output");
          } //  if
        }
  }

  public static void recursiveOutput(BufferedReader input, PrintWriter output)
  throws Exception
  {
    String outputLine;
    String headLine = input.readLine();
    if(headLine != null)
      {
      if((outputLine = input.readLine()) != null)
        {
          recursiveOutput(input, output);
          output.println(outputLine);
        }

      }
    output.println(headLine);
  }

}
