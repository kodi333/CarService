package frameButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GetLogNapraw {
	
	public GetLogNapraw(){
		
		Statement stmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://mssql.iisg.agh.edu.pl;databaseName=krudzki_b","krudzki","Q7h1pPKq");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Creating statement...");
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql;
	    sql = "SELECT ServiceOrder as [L.p. Uslugi],"
	    		+ "ServiceStartDate as [Data rozpoczecia],"
	    		+ "ServiceName as [Nazwa Uslugi],"
	    		+ "AssignedStation as [Numer Stanowiska], "
	    		+ "CarRegNumber as [Numer rejestracyjny samochodu]"
	    		+ "FROM [krudzki_b].[dbo].[ServicesLog]";
	    try {
			ResultSet rs = stmt.executeQuery(sql);
			 // It creates and displays the table
		    JTable table = new JTable(buildTableModel(rs));
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		    table.getColumnModel().getColumn(0).setMaxWidth(70);
		    table.getColumnModel().getColumn(1).setMaxWidth(100);
		    table.getColumnModel().getColumn(2).setMaxWidth(150);
		    table.getColumnModel().getColumn(3).setMaxWidth(150);
		    table.getColumnModel().getColumn(4).setMaxWidth(150);
//		    table.getColumnModel().getColumn(5).setMinWidth(80);
//		    table.getColumnModel().getColumn(6).setMinWidth(80);

		    JScrollPane panelTabela = new JScrollPane(table);
		    
		    JOptionPane paneMessage = new JOptionPane(panelTabela);
		    JDialog dialog = paneMessage.createDialog("Log Serwisowy");
		    dialog.setBounds(100, 100, 620, 400);
		    dialog.setVisible(true);

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
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
}