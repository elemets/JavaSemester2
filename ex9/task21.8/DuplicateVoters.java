import java.util.HashSet;
import java.util.Set;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collection;


public class DuplicateVoters
{

    public static void main(String[] args)
    {
        // defining the input and output ready to be used
        BufferedReader input = null;
        PrintWriter output = null;

        // if there isn't two arguments supplied then throw an exception
        if (args.length != 2)
            throw new IllegalArgumentException("Wrong number of files!");


        
        try
        {
            // Mapping them tings there
            Map<String, String> votersMapped = new HashMap<String, String>();


            // setting up the input and output
            input = new BufferedReader(new FileReader(args[0]));
            output = new PrintWriter(new FileWriter(args[1]));

            // while the current line isn't null add the line into the Set
            String voterID;


            while ((voterID = input.readLine()) != null)
            {
              String votingTime = input.readLine();
               // adding each line to the hashMap
              if(votersMapped.get(voterID) == null)
                  votersMapped.put(voterID, votingTime);
              else
              {
                output.println(voterID);
                output.println("duplicate vote: " + votingTime);
              }
            }

        }
        catch(IOException e) {
            System.out.println("IO Exception caught!!");
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
