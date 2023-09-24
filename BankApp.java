import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

class generate{
    
    public String numbersGenarator="0123456789";
}

public class BankApp {
    generate bring = new generate();
    Access calling = new Access();
    private int choice,AccountPassword;
    // BigInteger  = new BigInteger(AccountNumberGenerator());
    
    String AccountType=null;
    private String AccountHolderName=null;
    private String Account_Number;
    private double deposite,balance,withdraw;
    private char randomchar;
    public String VerifyAccountNumberQuery,query; 
    static private String NewUserInsertQuery="INSERT INTO bank_details(AccountType,AccountNumber,AccountHolder_Name,Balance,Password) VALUES(?,?,?,?,?)";
    private static final String jdbc ="jdbc:mysql://localhost:3306/bank";
    private static final String Username = "root";
    private static final String Password = "Zappy888";
    
    Connection connection=null;
    
    
    Statement statement=null;
    ResultSet result=null;
    PreparedStatement preparedStatement;
    
    
    Scanner call = new Scanner(System.in);
    public void DATABASECONNECTION(){
        
        try {
            connection=DriverManager.getConnection(jdbc, Username, Password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }
    public void input(){
        DATABASECONNECTION();
        System.out.println("Welcome To The Bank\n1. Existing User\n2. Create New Account");
        choice=call.nextInt();
        switch (choice) {
            case 1:
                    DATABASECONNECTION();
                    ExistingUser();
                    break;
                    case 2:
                    DATABASECONNECTION();
                    NewUser();
                    break;
                    
                    default:
                    System.out.println("Invalid Input");
                    break;
                }
            }   
            
            //*****************************EXISTING  USER************************/
            public void ExistingUser()
            {
                
                call.nextLine(); 
                System.out.println("Enter Your Unique Account Number");
                Account_Number=call.nextLine(); 
                
                try {
                    VerifyAccountNumberQuery="SELECT * FROM bank_details WHERE AccountNumber = '"+Account_Number+"'"; 
                    
                    result= statement.executeQuery(VerifyAccountNumberQuery); 
                    
                    if(result.next())
                    {
                        System.out.println("Account Exists.");
                        System.out.println("Choose...\n1. Deposite\n2. Balance\n3. Withdraw");
                    }
                    else{
                        System.out.println("Account Does Not Exists.");
                        
                    }
                    choice=call.nextInt();
                    switch (choice) {
                        case 1:
                        deposite();
                        break;
                        
                        case 2:
                        
                        balance();
                        System.out.println("Your Current Balanace is "+balance);
                        break;
                        
                        case 3:
                            
                        withdraw();
                        break;
                            
                            default:
                            System.out.println("Invaild Option");
                            break;
                        }
                    result.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            }
            void deposite() throws SQLException
            {
                    query="SELECT Balance FROM bank_details WHERE AccountNumber = '"+Account_Number+"'";
                        result=statement.executeQuery(query);
                        while(result.next()){

                            deposite=result.getDouble("Balance");
                        }
                        deposite+=calling.Deposit();
                        query="UPDATE bank_details SET Balance = ? WHERE AccountNumber='"+Account_Number+"'";
                        preparedStatement=connection.prepareStatement(query);
                    
                        preparedStatement.setDouble(1, deposite);
                        preparedStatement.executeUpdate();
                        System.out.println(deposite);
            }
            double balance() throws SQLException
            {
                     query="SELECT Balance FROM bank_details WHERE AccountNumber = '"+Account_Number+"'";
                        result=statement.executeQuery(query);
                        if (result.next()) {
                            
                            balance=result.getDouble("Balance");
                        }

                        return balance;
            }
            void withdraw() throws SQLException
            {
                  System.out.println("Enter The Withdrawl Amount");
                  withdraw=call.nextDouble();
                  balance=balance();
                  if(withdraw>balance){

                  System.out.println("Your Withrawl Amount is Greater Than Your Current Balance");
                  
                  }
                  else{
                        balance-=withdraw;

                     query="UPDATE bank_details SET Balance = ? WHERE AccountNumber='"+Account_Number+"'";
                        preparedStatement=connection.prepareStatement(query);
                    
                        preparedStatement.setDouble(1, balance);
                        preparedStatement.executeUpdate();
                        System.out.println("Do You Want To See Your Balnce After Withdrawl y/n");
                        randomchar=call.next().charAt(0);
                        if(randomchar=='y'||randomchar=='Y'){
                        System.out.println("Your Balance "+balance());
                        
                        }
                  }
            }
            
            void AccountNumberSetter(){
               
                    Account_Number = AccountNumberGenerator();
         
                    try {
                        VerifyAccountNumberQuery="SELECT * FROM bank_details WHERE AccountNumber = '"+Account_Number+"'"; 
                        result= statement.executeQuery(VerifyAccountNumberQuery);
                        
                        
                        if(result.next())
                        {
                            AccountNumberSetter();
                        }
                        else{
                          
                            System.out.println("Here Is Your Unique Account Number "+Account_Number);
                        }
                        
                    } catch (SQLException e) {
                        
                         e.printStackTrace();
                    }
                }
                
            
            //*****************************NEW  USER************************/
            public void NewUser(){
                System.out.println("What kind of Account You Want To Open\n1. Current  2.Saving");
                choice=call.nextInt();
                if (choice==1) {
                    AccountType="Current";
                } else {
                    AccountType="Saving";
                }
                call.nextLine();
                System.out.println("Enter Your Full Name");
                AccountHolderName=call.nextLine();
                
                System.out.println("Enter Your First deposite >500");
                deposite=call.nextDouble();
                balance=deposite;
                
                System.out.println("Enter 8 digit Password ");
                AccountPassword=call.nextInt();
                
                AccountNumberSetter();
                
                try {
                    preparedStatement=connection.prepareStatement(NewUserInsertQuery);
                    preparedStatement.setString(1, AccountType);
                    preparedStatement.setBigDecimal(2, new BigDecimal(Account_Number));
                    preparedStatement.setString(3,  AccountHolderName);
                    preparedStatement.setDouble(4, balance);
                    preparedStatement.setInt(5, AccountPassword );
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                } catch (SQLException e) {
                    
                    System.out.println("ERROR");
                   
                }
            }
            public String AccountNumberGenerator()
            {
                Random random = new Random();
                StringBuilder stringbuilder = new StringBuilder(15);
                for(int i=0;i<15;i++)
                {
                    choice=random.nextInt(bring.numbersGenarator.length());
                    randomchar=bring.numbersGenarator.charAt(choice);
                    stringbuilder.append(randomchar);
                    
                }
                return stringbuilder.toString(); 
            } 
    public static void main(String[] args){ 
      BankApp start= new BankApp();
      start.input();
        }
    
}