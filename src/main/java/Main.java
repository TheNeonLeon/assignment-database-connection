import com.chinook.connection.ConnectionManager;
import com.chinook.dataaccess.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection conn = ConnectionManager.getInstance().getConnection();

        ConnectionManager connectionManager = new ConnectionManager();
        ArrayList<Customer> customers = connectionManager.selectAllCustomers();
        printCustomers(customers);
    }

    public static void printCustomers(ArrayList<Customer> customers) {
        if(customers.size() != 0) {
            for(Customer c : customers){
                System.out.println(c.getCustomerId());
                System.out.println(c.getFirstName());
                System.out.println(c.getLastName());
                System.out.println(c.getPhone());
                System.out.println(c.getEmail());
            }
        }else{
            System.out.println("No customers found");
        }
    }

      /* try{
           PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId,FirstName," +
                   "Company FROM Customer WHERE Company IS NULL");

//           preparedStatement.setString(1,"''");

           ResultSet resultSet = preparedStatement.executeQuery();

//           Statement statement = conn.createStatement();

           while( resultSet.next()){
               String customerId = resultSet.getString("CustomerId");
               String customerName = resultSet.getString("FirstName");
               String customerTitle = resultSet.getString("Company");
               System.out.printf("Customer {%s, %s, %s}%n", customerId, customerName, customerTitle);
           }
           conn.close();
       } catch (SQLException sqe){
           sqe.printStackTrace();
           System.exit(-1);
       }
    }*/
}