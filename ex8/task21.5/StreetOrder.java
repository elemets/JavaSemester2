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
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


public class StreetOrder
{
    public static void main(String[] args) throws IllegalArgumentException
    {
        BufferedReader input = null;
        PrintWriter output = null;

        String currentLine;
        String oddHouseLine;

        TreeSet<DeliveryHouseDetails> houseList = new TreeSet<DeliveryHouseDetails>();

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

            int lineNumber = 0;

            // go through the file and add each line to the arraylist houseList
            // while the the current line isn't the end of the file
            while((currentLine = input.readLine()) != null)
            {
                lineNumber ++;
                houseList.add(new DeliveryHouseDetails(lineNumber, currentLine));
            }

            Iterator<DeliveryHouseDetails> iterator = houseList.iterator();

            // output the lines
            while(iterator.hasNext())
                output.println(iterator.next().getHouse());


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
