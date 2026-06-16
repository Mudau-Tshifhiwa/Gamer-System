import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class testGamer
{
    public static void main(String[] args)
    {
        final int size = 25;

        Gamer []arrGamer = new Gamer[size];

        int count = ReadData(arrGamer);

        DisplayAmGamers(arrGamer , count);
        System.out.println("\n");
        DisplayProGamers(arrGamer ,count);
        System.out.println("\n");
        CalcTotalDiscountForAmgamers(arrGamer ,count);
        CalcTotalDiscountForProgamers(arrGamer ,count);

        arrGamer = Arrays.copyOf(arrGamer , count);
        Arrays.sort(arrGamer);
        AfterSortingInformation(arrGamer ,count);

    }

    public static int ReadData(Gamer [] arrGamer)
    {
        int count = 0;


        try
        {
            Scanner input = new Scanner(new FileReader("gamers.txt"));
            while(input.hasNext())
            {
                String Line = input.nextLine();
                String []info = Line.split("@");

                String status = info[0];
                String IdNumber = info[1];
                String Name = info[2];

                if(status.equals("Amateur"))
                {
                    int category = Integer.parseInt((info[3]));
                    try
                    {
                        arrGamer[count] = new AmGamer(status , IdNumber , Name  , category);
                    }catch(InvalidIdException message)
                    {
                        System.out.println(message.getMessage());
                    }

                }
                else {
                    int yearsInGame = Integer.parseInt(info[3]);
                    int rank = Integer.parseInt(info[4]);
                    try
                    {
                        arrGamer[count] = new ProGamer(status , IdNumber , Name ,rank , yearsInGame);
                    }catch(InvalidIdException message)
                    {
                        System.out.println(message.getMessage());
                    }

                }
                count++;
            }

        }catch (FileNotFoundException message)
        {
            System.out.println(message.getMessage());
        }
        return count;
    }
    public static  void DisplayAmGamers(Gamer [] arrGamer , int count)
    {
        System.out.println("Amateur gamers\n");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s" , "Code" , "ID number" , "Name" , "Category" , "Registration fee" , "Discount");
        for(int x =0;x<count;x++)
        {
            if(arrGamer[x] instanceof  AmGamer)
            {
                AmGamer CurrentOne = (AmGamer) arrGamer[x];
                System.out.println(CurrentOne.toString());


            }
        }
    }

    public static void CalcTotalDiscountForAmgamers(Gamer[] arrGamer , int count)
    {
       double TotaDiscount = 0;
       for(int x =0;x< count;x++)
       {
           if(arrGamer[x] instanceof  AmGamer)
           {
               AmGamer CurrentOne = (AmGamer) arrGamer[x];
               TotaDiscount += CurrentOne.calcDiscount();

           }
       }
       System.out.println("Total discount for Amateurs: " + "R" + TotaDiscount);
    }
    public static void DisplayProGamers(Gamer[] arrGamer , int count)
    {
        System.out.println("Profesional gamers\n");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s" , "Code" , "ID number" , "Name" , "Years" , "Rank" , "Discount");
        for(int x =0;x<count;x++)
        {
            if(arrGamer[x] instanceof  ProGamer)
            {
                ProGamer CurrentOne = (ProGamer) arrGamer[x];
                System.out.println(CurrentOne.toString());


            }
        }
    }
    public static void CalcTotalDiscountForProgamers(Gamer[] arrGamer , int count)
    {
        double TotaDiscount = 0;
        for(int x =0;x< count;x++)
        {
            if(arrGamer[x] instanceof  ProGamer)
            {
                ProGamer CurrentOne = (ProGamer) arrGamer[x];
                TotaDiscount += CurrentOne.calcDiscount();

            }
        }
        System.out.println("Total discount for Professionals: " + "R" + TotaDiscount);
    }
    public static void AfterSortingInformation(Gamer[] arrGamer , int count)
    {
        System.out.println("After sorting\n");
        System.out.printf("%-10s %-10s %-10s %-10s" , "Code" , "ID number" , "Name" , "Discount");

        for(int x =0;x<count;x++)
        {
            System.out.printf("%n%-10s %-10s %-10s %-10.2f" , arrGamer[x].generateCode() , arrGamer[x].getIdNumber()
                    , arrGamer[x].getName() , arrGamer[x].calcDiscount());
        }
    }

    public static void SerilizeObjects(Gamer[] arrGamer , int count)
    {
        try
        {
            ObjectOutputStream OutPut = new ObjectOutputStream(new FileOutputStream("gamers.ser"));
            for(int x =0;x<count;x++)
            {
                OutPut.writeObject(arrGamer[x]);
            }
            System.out.println("Objects has been resialized\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
