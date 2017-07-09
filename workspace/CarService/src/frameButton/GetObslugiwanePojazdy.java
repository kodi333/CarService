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

public class GetObslugiwanePojazdy {
	
	public GetObslugiwanePojazdy(){
		
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
	    sql = "SELECT C.Mark as Marka,C.Model as Model,C.RegistrationNumber as [Numer rejestracyjny], AssignedStation as [Numer Stanowiska],"
	    		+ " ServiceStartDate as [Data rozpoczecia]"
	    		+ " FROM [krudzki_b].[dbo].[ServicesLog] as S INNER JOIN [krudzki_b].[dbo].[ClientCars] as C"
	    		+ " ON S.CarRegNumber = C.RegistrationNumber"
	    		+ " WHERE S.Finished = 'Nie'";
	    try {
			ResultSet rs = stmt.executeQuery(sql);
			 // It creates and displays the table
		    JTable table = new JTable(buildTableModel(rs));
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		    table.getColumnModel().getColumn(0).setMinWidth(70);
		    table.getColumnModel().getColumn(1).setMinWidth(90);
		    table.getColumnModel().getColumn(2).setMinWidth(90);
		    table.getColumnModel().getColumn(3).setMinWidth(150);
		    table.getColumnModel().getColumn(4).setMinWidth(150);
//		    table.getColumnModel().getColumn(5).setMinWidth(150);


		    
		    JScrollPane panelTabela = new JScrollPane(table);
		    
		    JOptionPane paneMessage = new JOptionPane(panelTabela);
		    JDialog dialog = paneMessage.createDialog("Obecnie obslugiwane pojazdy");
		    dialog.setBounds(100, 100, 1200, 400);
		    dialog.setVisible(true);

		    //panelTabela.getMinimumSize().setSize(600, 400);
		    
//		    panelTabela.setSize(new Dimension(480, 10));
//		    panelTabela.setPreferredSize(new Dimension(480, panelTabela.getPreferredSize().height));
		    
		    //panelTabela.getFrame().setSize(600,200);
		    
//		    JScrollBar bar = panelTabela.getVerticalScrollBar();
//		    bar.setPreferredSize(new Dimension(600, 200));
//		    JOptionPane paneMessage = new JOptionPane(panelTabela);
//		    paneMessage.setSize(800,300);
//		    
//		    JDialog dialog = paneMessage.createDialog("Tytul");
//		    dialog.pack();
//		    dialog.setVisible(true);
		    
		    //paneMessage.getFrameForComponent(panelTabela).setSize(new Dimension(800,200));
		    //paneMessage.showMessageDialog(null, panelTabela);
			
/*			while (rs.next())
			{

			    System.out.print("Column 1 returned ");
			    System.out.println(rs.getString(1));
			    System.out.print("Column 2 returned ");
			    System.out.println(rs.getString(2));
			}*/
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