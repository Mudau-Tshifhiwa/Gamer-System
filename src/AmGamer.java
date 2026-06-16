public class AmGamer extends Gamer
{
    private int category;
    private final double AmGamerFee = 250;

    public AmGamer(){}
    public AmGamer(String status , String IdNumber , String Name ,int category) throws InvalidIdException
    {
        super(status , IdNumber , Name);
        this.category = category;
    }
    public int getCategory(){return category;}

    @Override
    public String generateCode()
    {
        return "A" + super.getIdNumber().substring(0,4) +"-" + String.valueOf(category);
    }

    @Override
    public double calcRegistrationFee()
    {
         return AmGamerFee - calcDiscount();
    }
    @Override
    public double calcDiscount()
    {
       if(super.calcAge() <= 18)
       {
           double amGamerDiscount = 0.2;
           return AmGamerFee * amGamerDiscount;
       }
       return 0;
    }
    public String toString()
    {
        return String.format("%-10s %-10s %-10d %-10.2f %-10.2f" , this.generateCode() , super.toString() ,
                this.getCategory() , this.calcRegistrationFee() , this.calcDiscount());
    }



}
