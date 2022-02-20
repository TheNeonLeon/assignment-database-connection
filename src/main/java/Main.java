import com.chinook.connection.ConnectionManager;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = ConnectionManager.getInstance().getConnection();

        try{
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
    }
}
