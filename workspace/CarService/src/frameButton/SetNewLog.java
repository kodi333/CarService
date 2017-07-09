package frameButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetNewLog {
//	Scanner reader = new Scanner(System.in);  // Reading from System.in

	public SetNewLog(){
		
		//Assign value to variables
		
		Integer stations = (Integer) InsertServicesLog.getStations().getSelectedItem();
		String finished= (String) InsertServicesLog.getFinished().getSelectedItem();
		String services= (String) InsertServicesLog.getServices().getSelectedItem();
		String plates = (String) InsertServicesLog.getPlates().getSelectedItem();

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

		String sql; 
		sql = "INSERT INTO [krudzki_b].[dbo].[ServicesLog] ([ServiceStartDate],[ServiceName],[AssignedStation],[CarRegNumber],[Finished])" +
			"VALUES ( GETDATE(),'"+ services +"','"+ stations +"','" + plates + "','" + finished + "')";
		
		try {
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

