package frameButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetNewEmployee {
//	Scanner reader = new Scanner(System.in);  // Reading from System.in

	public SetNewEmployee(){

//		String clientName= JOptionPane.showInputDialog("Wprowadz imie klienta: ");
//		String clientLastName= JOptionPane.showInputDialog("Wprowadz nazwisko klienta: ");
//		String clientAddress= JOptionPane.showInputDialog("Wprowadz adres zamieszkania klienta: ");
		
		
		//Assign value to variables
		
		String employeeName = InsertEmployeeFrame.getList().get(0).getText();
		String employeeLastName= InsertEmployeeFrame.getList().get(1).getText();
		String employeeAddress= InsertEmployeeFrame.getList().get(2).getText();
		String employeePESEL= InsertEmployeeFrame.getList().get(3).getText();
		String employeePosition = (String) InsertEmployeeFrame.getBookList().getSelectedItem();

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
		sql = "INSERT INTO [krudzki_b].[dbo].[EmployeeHR] ([EmployeeName],[EmployeeLastName],[EmployeePesel],[HomeAddress],[Position],[StartDate])" +
			"VALUES ('" + employeeName +"','"+ employeeLastName +"'," + employeePESEL + ",'"+ employeeAddress +"','" + employeePosition + "',CAST(GETDATE() AS DATE))";
		
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

