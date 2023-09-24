import java.util.Scanner;
class thing{
    int min=33,max=126;
    int num,size;
    String result;
    char convert;
}
public class passcode{

    public static void main(String[] args){
        Scanner call=new Scanner(System.in); 
        thing take =new thing();
        System.out.println("Enter The Size Of The Passcode");
        take.size=call.nextInt();
        for(int i=0; i<take.size;i++){
            take.convert=(char) (Math.random()*(take.max-take.min+1)+take.min); 
            System.out.print(take.convert);
        }
        call.close();
    }
}