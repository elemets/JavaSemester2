import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;

public class DeleteFieldException extends Exception
{

	public DateException()
	{
		super();
	}

	public DateException(String message)
	{
		super(message);
	}

	public DateException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DateException(Throwable cause)
	{
		super(cause);
	} 

}
