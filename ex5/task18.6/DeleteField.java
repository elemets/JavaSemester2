import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;

public class DeleteField
{
    public static void main(String[] args)
    {
      // defining variables
      BufferedReader input = null;
      PrintWriter output = null;


      String currentLine;
      int fieldToDelete = Integer.parseInt(args[0]);

      try
      {
        // if only one argument supplied then use the system in and out
        if(args.length == 1)
        {
          // using system in and out
          input = new BufferedReader(new InputStreamReader(System.in));
          output = new PrintWriter(System.out, true);
        }
        // if argument is 2 then check if the file exists
        // if it exists then the file is the input if it doesn't its the output
        else if (args.length == 2 && (new File(args[1]).exists()))
        {
          input = new BufferedReader(new FileReader(args[1]));
          output = new PrintWriter(System.out, true);
        }
        // this is if the file doesn't exist
        else if (args.length == 2 && !(new File(args[1]).exists()))
        {
          input = new BufferedReader(new InputStreamReader(System.in));
          output = new PrintWriter(new FileWriter(args[1]));
        }
        else
        {
          // using the files as input and output
          input = new BufferedReader(new FileReader(args[1]));
          output = new PrintWriter(new FileWriter(args[2]));
        }

          while((currentLine = input.readLine()) != null)
          {
            String[] fields = currentLine.split("\t");
            String editedLine = "";
            if(fields.length < fieldToDelete)
              editedLine = currentLine;
            else
            {
              for (int index =0; index < fieldToDelete -1 ; index++)
                if(editedLine.equals("")) editedLine = fields[index];
                else                      editedLine += "\t" + fields[index];

              for(int index = fieldToDelete; index < fields.length; index++)
                editedLine += "\t" + fields[index];
            }
            // outputting the edited file
            output.println(editedLine);
          } //while
      }
      // catching IO exception
      catch(IOException exception)
      {  System.out.println(exception.getMessage()); }
      // trying to close the input and output
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
