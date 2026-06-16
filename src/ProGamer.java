public class ProGamer extends Gamer
{
    private int rank;
    private int yearsInGame;
    private final double ProGamerFee = 500;


    public ProGamer(){}

    public ProGamer(String status , String IdNumber , String Name , int rank , int yearsInGame) throws  InvalidIdException
    {
        super(status , IdNumber , Name);
        this.rank = rank;
        this.yearsInGame = yearsInGame;
    }

    public int getRank(){return rank;}
    public int getYearsInGame(){return yearsInGame;}

    @Override
    public String generateCode()
    {
       return "P" + String.valueOf(rank) + String.valueOf(super.calcAge()) +"-" + String.valueOf(yearsInGame);
    }
    @Override
    public double calcRegistrationFee()
    {
        return ProGamerFee - calcDiscount();
    }
    @Override
    public double calcDiscount()
    {
        if(this.getYearsInGame() >=10)
        {
            return ProGamerFee * 0.50;
        }
        return ProGamerFee * (0.05 * this.getYearsInGame());

    }

    @Override
    public String toString()
    {
       return String.format("%-10s %-10s %-10d %-10d %-10.2f %-10.2f" , this.generateCode() , super.toString() , this.getYearsInGame()
       ,this.getRank() ,this.calcRegistrationFee() , this.calcDiscount());
    }



}
