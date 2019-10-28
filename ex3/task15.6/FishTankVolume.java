public class FishTankVolume
{
 public static void main(String[] args) {

   try{

     int width = Integer.parseInt(args[0]);
     int depth = Integer.parseInt(args[1]);
     int height = Integer.parseInt(args[2]);
     int volume = width * depth * height;

     if (args.length > 3 || args.length < 3)
     {
       throw new ArrayIndexOutOfBoundsException
       ("You have supplied too many or too few arguments");
     }
    else if(width < 0 || depth < 0 || height < 0)
    {
      throw new NumberFormatException
      ("One of the arguments you supplied was a negative number!");
    }
    System.out.println("The volume of a tank with dimensions "
    + "(" + width + "," + depth + "," + height + ") " + "is " + volume);
   }
   catch (ArrayIndexOutOfBoundsException exception1)
   {
     System.out.println
     ("Please supply three numbers so the voume can be calculated thank you.");
     System.out.println("Exception message was: " + exception1.getMessage());
     System.err.println(exception1);
   }
   catch(NumberFormatException exception2)
   {
     System.out.println("Only supply positive integers! No strings!!");
     System.out.println("Exception message was: " + exception2.getMessage());
     System.err.println(exception2);
   }
   catch(Exception exception)
   {
     System.out.println
     ("You managed to mess up so wildly," +
     " it wasn't even predictable. Well done.");
     System.out.println("Exception message was: " + exception.getMessage());
     System.err.println(exception);
   }
 }
}

