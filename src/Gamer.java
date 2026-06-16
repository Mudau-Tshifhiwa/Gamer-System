import java.io.Serializable;
import java.math.*;

public abstract class Gamer implements Serializable , Comparable<Gamer>
{
    private String status;
    private String IdNumber;
    private String Name;

    public Gamer(){}

    public Gamer(String status , String IdNumber , String Name) throws InvalidIdException
    {
        this.status = status;
        this.IdNumber = IdNumber;
        setIdNumber(IdNumber);
        this.Name = Name;
    }
    public String getStatus(){return status;}
    public String getIdNumber(){return IdNumber;}
    public String getName(){return Name;}

    public abstract String generateCode();
    public abstract  double calcRegistrationFee();
    public abstract  double calcDiscount();

    public int calcAge()
    {
        int currentYear = 2025;
        if(Integer.parseInt(IdNumber.substring(0,2)) < 25)
        {
            return currentYear - 2000+Integer.parseInt(IdNumber.substring(0,1));
        }
        else
        {
            return currentYear - 19000+Integer.parseInt(IdNumber.substring(0,1));
        }
    }
    public int compareTo(Gamer SecondGamer)
    {
        return this.IdNumber.compareTo(SecondGamer.IdNumber);
    }
    private void setIdNumber(String IdNumber) throws InvalidIdException
    {
        boolean isValidLenth =  false;
        boolean isDigits = true;

        try
        {
            int Digits = Integer.parseInt(IdNumber);
        }catch (Exception e)
        {
            isDigits = false;
        }

        if(IdNumber.length() == 6)
        {
            isValidLenth = true;
        }
        if(!isDigits)
        {
            throw(new InvalidIdException("Id must only contain digits. ID = " + IdNumber));
        }
        else if(!isValidLenth)
        {
            throw (new InvalidIdException("Must be 6 digits. ID = " + IdNumber));
        }
        else if(!isDigits && !isValidLenth)
        {
            throw(new InvalidIdException("ID is incorect"));
        }



    }

    public String toString()
    {
        return String.format("%-10s %-10s" , this.IdNumber , this.Name);
    }



}
