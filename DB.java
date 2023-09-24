import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
        private static final String jdbc ="jdbc:mysql://localhost:3306/friends";
        private static final String Username = "root";
        private static final String Password = "Zappy888";
        public static  Connection connection() throws SQLException{
                return DriverManager.getConnection(jdbc, Username, Password);
        }
        private String query,name;
        // private int ID;
        Scanner call = new Scanner(System.in);
        public void LibraryApp() {
        
                query="INSERT INTO friend (Name,Bond) VALUES (?,?)";
                try {

                        System.out.println("Enter your Name");
                        name=call.nextLine();
                        System.out.println("Enter your Bond");
                        bond=call.nextLine();

                        Connection connection =  DB.connection();
                        Statement statement = connection.createStatement();
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        
                        preparedStatement.setString(1,name);
                        preparedStatement.setString(2,bond);
                        int num=preparedStatement.executeUpdate();
                        System.out.println("number of rows affected "+num);
                        // ResultSet resultSet=statement.executeQuery(query);

                        // while (resultSet.next()) {
                        //         name =resultSet.getString("Name");
                        //         bond =resultSet.getString("Bond");
                        //         ID =resultSet.getInt("ID");
                        //         System.out.println(ID+" "+name+" "+ bond);
                        // }
                        preparedStatement.close();
                        connection.close();
                        call.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        } 
        String bond;
        void inputstream(){
                
        }

        void startQuery() throws SQLException {
            ResultSet result;
            System.out.println("Enter the bond");
            bond = call.nextLine(); // Read the bond value from user input
        
                query= "SELECT * FROM friend WHERE Bond = '" + bond + "'";
            Connection connection = DB.connection(); 
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
        
            if (result.next()) {
                // Data is found in the result set, so you can retrieve and print it
                do {
                    bond = result.getString("Bond");
                    System.out.println("got it: " + bond);
                } while (result.next());
            } else {
                // No data found in the result set
                System.out.println("No matching records found.");
            }
        
            // Close resources (result set, statement, and connection)
            if (result != null) {
                result.close();
            }
            statement.close();
            connection.close();
        }
        
        public static void main(String[] args) throws SQLException{ 
                DB call = new DB();
                call.startQuery();
        }
}