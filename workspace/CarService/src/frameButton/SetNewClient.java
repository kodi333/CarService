package frameButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetNewClient {
//	Scanner reader = new Scanner(System.in);  // Reading from System.in

	public SetNewClient(){
		
		//Assign value to variables
		
		String clientName = InsertClientFrame.getList().get(0).getText();
		String clientLastName= InsertClientFrame.getList().get(1).getText();
		String clientAddress= InsertClientFrame.getList().get(2).getText();
		String mark= InsertClientFrame.getList().get(3).getText();
		String plates= InsertClientFrame.getList().get(4).getText();
		String model= InsertClientFrame.getList().get(5).getText();
		String color = InsertClientFrame.getList().get(6).getText();
		String categoryName = (String) InsertClientFrame.getBookList().getSelectedItem();
		String carCategories = (String) InsertClientFrame.getCategories().getSelectedItem();



		Statement stmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://mssql.iisg.agh.edu.pl;databaseName=krudzki_b","krudzki","Q7h1pPKq");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println("Creating statement...");
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql;String sql2;
		sql2 = "INSERT INTO [krudzki_b].[dbo].[ClientCars] ([RegistrationNumber],[Mark],[Color],[Model],[CategoryName])" +
				"VALUES ('" + plates +"','"+ mark +"','"+ color +"','" + model + "','" + carCategories + "')";
		
		sql = "INSERT INTO [krudzki_b].[dbo].[Clients] ([RegistrationNumber],[ClientAddress],[Name],[LastName],[CategoryName])" +
			"VALUES ('" + plates +"','" + clientAddress +"','"+ clientName +"','"+ clientLastName +"','" + categoryName + "')";

		try {
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if (connection !=null) {
			System.out.print("Udalo sie");
		} else {
			System.out.print("UPS");
		}
	}

}

