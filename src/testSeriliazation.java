import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class testSeriliazation
{
    public static void main(String[] args)
    {
        try
        {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("gamers.ser"));
            while(true)
            {
                try
                {
                    Gamer arrGamers = (Gamer)input.readObject();
                    System.out.printf("%n%-10s %-10s" , arrGamers.getIdNumber() , arrGamers.getName());

                }catch(Exception e)
                {
                    System.out.println("End of file has been reached");
                    break;
                }

            }
            
        }catch(IOException message)
        {
            System.out.println(message.getMessage());
        }
    }
}
