import java.util.HashSet;
import java.util.Set;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class DuplicateVoters
{

    public static void main(String[] args)
    {
        // defining the input and output ready to be used
        BufferedReader input = null;
        PrintWriter output = null;

        String currentLine;

        // if there isn't two arguments supplied then throw an exception
        if (args.length != 2)
            throw new IllegalArgumentException("Wrong number of files!");

        // creating the set "setting up ;-)" setting up with type String
        // Setting up duplicate voters hash set

        try
        {
            Set<String> voterNames = new HashSet<String>();
            List<String> duplicateVoters = new ArrayList<String>();

            // setting up the input and output
            input = new BufferedReader(new FileReader(args[0]));
            output = new PrintWriter(new FileWriter(args[1]));

            // while the current line isn't null add the line into the Set
            while ((currentLine = input.readLine()) != null)
            {
                // if the add returns false then there is already the item present add voters to duplicate voters
                if (voterNames.add(currentLine) == false)
                    duplicateVoters.add(currentLine);
            }

        for(int index = 1; index < duplicateVoters.size(); index += 1) {
            output.println(duplicateVoters.get(index));

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