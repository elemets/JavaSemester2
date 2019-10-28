import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.Collections;


public class StreetOrder
{
  public static void main(String[] args) throws IllegalArgumentException
  {
    BufferedReader input = null;
    PrintWriter output = null;

    String currentLine;
    String oddHouseLine;

    List<String> houseList = new ArrayList<String>();

    // the program will only work with one input and one output
    // so we need to limit the number of arguments required
    if(args.length != 2)
      throw new IllegalArgumentException("You need to specify files!");


    try
    {

      // defining the input as the first argument
      input = new BufferedReader(new FileReader(args[0]));

      // defining the output as the second argument
      output = new PrintWriter(new FileWriter(args[1]));

      // while the the current line isn't the end of the file then
      // go through the file and add each line to the arraylist houseList
      while((currentLine = input.readLine()) != null)
      {
        houseList.add(currentLine);
      }

      // looping through the even indicies in house list which are in fact the
      // odd numbered houses
      for(int oddHouseIndex = 0; oddHouseIndex < houseList.size();
       oddHouseIndex += 2)
        {
          oddHouseLine = houseList.get(oddHouseIndex);
          output.println(oddHouseLine);
                    System.out.println(oddHouseLine);
        }
      // if houseList size is divisible by 2 with no remainder then it is even
      // which means the last house is odd so the backwards loop starts from
      // the house list size minus 1
      if(houseList.size() % 2 == 0)
      {
        // looping through the odd indicies backwards in house list which
        // are the even houses
        for(int evenHouseIndex = houseList.size() - 1; evenHouseIndex >= 1;
            evenHouseIndex -= 2)
        {
          String evenHouseLine = houseList.get(evenHouseIndex);
          output.println(evenHouseLine);
          System.out.println(evenHouseLine);
        }
      } // if the houseList size isn't divisible by 2 then it is odd which means
      // the last house is even so can just go back from there
      else
      {
        for(int evenHouseIndex = houseList.size(); evenHouseIndex >= 1;
            evenHouseIndex -= 2)
        {
          String evenHouseLine = houseList.get(evenHouseIndex);
          output.println(evenHouseIndex);
          System.out.println(evenHouseLine);
        }
      }
    }
    catch(IOException e)
    {
      System.out.println("IO Exception caught!");
    }
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
}
