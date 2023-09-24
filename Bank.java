import java.util.Scanner;

class Source// Sources
{
    int num;
    double withdraw, deposite, balance;
}

/* Access of Sources */
class Access extends Source {

    Scanner call = new Scanner(System.in);

    /************ WITHDRAW ***************/
    public double Withdraw() {

        System.out.println("Enter The Withdrawl Amount");
        withdraw = call.nextFloat();
        if (withdraw > balance) {
            System.out.println("You Don't have Enough Balance to Withdraw");
            if (num == 3) {
                balance -= withdraw;
                System.out.println(
                        "Steel You Can Withdraw The Amount ,But By The Due Date You Have To Pay The Negative Amount\nThe Fine After The Due Date Is"
                                + ((balance -= withdraw) * 1.5));

            }
        } else {
            balance -= withdraw;
            System.out.println("After your Withdrawl of " + withdraw + " ,Now Your Balance is " + balance);
        }
        return balance;
    }
    

                /*************************** DEPOSIT **********************/
    public double Deposit() {
    
        System.out.println("Enter The Amount You Want to Deposite");
        deposite = call.nextFloat();
        balance += deposite;
        System.out.println("Now your Balance After Depostie is " + balance);
        return balance;
    }

    /************ BALANCE ***************/
    void Balance() {
        System.out.println("Your balance is " + balance);
    }
}

public class Bank extends Access {

    Scanner call = new Scanner(System.in);

    /************ SAVIING ACCOUNT ***************/
    void Saving() {
        System.out.println("Enter The Balance Of Your Saving Account");
        balance = call.nextFloat();
        System.out.println("Enter The Mode Of Account 1.Withdraw\t2.Deposite\t3.Balance\n");
        try {
            num = call.nextInt();
            switch (num) {
                case 1:
                    Withdraw();
                    break;
                case 2:
                    Deposit();
                    break;
                case 3:
                    Balance();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    /************ CURRENT ACCOUNT ***************/
    void Cureent() {
        System.out.println("Enter The Balance Of Your Current Account");
        balance = call.nextFloat();
        System.out.println("Enter The Mode Of Account 1.Withdraw\t2.Deposite\t3.Balance\n");
        try {
            num = call.nextInt();
            switch (num) {
                case 1:
                    num = 3;
                    Withdraw();
                    break;
                case 2:
                    Deposit();
                    break;
                case 3:
                    Balance();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public static void main(String[] arg) {
        Bank take = new Bank();
        Scanner call = new Scanner(System.in);

        Source sor = new Source();
        System.out.println("Plaese Enter Account Mode:- 1.Saving\t2.Current");
        sor.num = call.nextInt();
        switch (sor.num) {
            case 1:
                System.out.println("You Have Choosen The Saving Account");

                take.Saving();
                break;
            case 2:
                take.Cureent();
                break;
        }
        call.close();
    }
}