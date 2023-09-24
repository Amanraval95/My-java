import java.util.Random;

public class practice {
    int give=0,waste;

    public void again()
    {
            
        waste=values();
        if(waste==8)
        {
            System.out.println(waste);
            System.out.println("Same");
      
                again();
            
        
        }
        else{
            System.out.println(waste);
        }
    }
    public int values()
    {
        give++;
        Random random = new Random();
        int take=random.nextInt(9);
        return take;
        
    }
   
    public static void main(String[] args){ 
    practice call = new practice();
    call.again();
        }
    
}