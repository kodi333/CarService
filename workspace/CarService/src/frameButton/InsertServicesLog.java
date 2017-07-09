package frameButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import Buttons.JButtonConnect;
import layout.SpringUtilities;

public class InsertServicesLog {
	
	public static JComboBox getStations() {
		return stations;
	}


	public static JComboBox getFinished() {
		return finished;
	}


	public static JComboBox getServices() {
		return services;
	}


	public static JComboBox getPlates() {
		return plates;
	}

	private static JComboBox stations = new JComboBox(new Object[]{1,2,3,4});
	
	private static JComboBox finished = new JComboBox(new Object[]{"Nie","Tak"});
	
	private static JComboBox services = new JComboBox(GetListaNrUslug().toArray());
	
	private static JComboBox plates = new JComboBox(GetListaTablic().toArray());



	public static void main(String []args)
	{
		new InsertServicesLog();
	}
	
	
	public InsertServicesLog() {
		
//		String labels = new String[];
//		int numPairs = labels.length;

		//Create and populate the panel.
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel(new SpringLayout());
		
		
//		for (int i = 0; i < numPairs; i++) {
//			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
//			p.add(l);
//			JTextField textField = new JTextField(10);
//			list.add(i,textField);
//			l.setLabelFor(textField);
//			p.add(textField);
//		}

		//add to the parent container (e.g. a JFrame):
		JLabel z = new JLabel("Stacja obslugujaca: ");
		p.add(z);
		p.add(stations);
		
		//add to the parent container (e.g. a JFrame):
		JLabel y = new JLabel("Czy usluga zostala juz zakonczona?");
		p.add(y);
		p.add(finished);
		
		//add to the parent container (e.g. a JFrame):
		JLabel x = new JLabel("Wprowadz numer uslugi");
		p.add(x);
		p.add(services);
		
		//add to the parent container (e.g. a JFrame):
		JLabel s = new JLabel("Tablice rejetracyjne pojazdu");
		p.add(s);
		p.add(plates);

		
		JButton Submit = new JButtonConnect("Wprowadz","SetNewLog");
		// exit frame on click
		Submit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       frame.dispose();
		    }
		});
		JLabel k = new JLabel();
		p.add(k);
		p.add(Submit);
		//Lay out the panel.
		SpringUtilities.makeGrid(p,
				5, 2, //rows, cols
				5, 5, //initialX, initialY
				5, 5);//xPad, yPad
		
		frame.add(p);
		frame.pack();
		frame.setTitle("Wprowadz nowy log");
		frame.setBounds(550, 200, 500, 340);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.add(panel);
		frame.setVisible(true);
	}
	
	public static List<String> GetListaNrUslug(){
		
    	List<String> servicesList = new ArrayList<String>();
		
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
		
	    try {
	    	
		    ResultSet namesList = stmt.executeQuery("SELECT [ServicesName] FROM [krudzki_b].[dbo].[Services]");
	    	while (namesList.next()) {
	    		servicesList.add(namesList.getString(1));
	    	}  

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (connection !=null) {
			System.out.print("Udalo sie");
		} else {
			System.out.print("UPS");
		}
		return servicesList;
	}
	
	public static List<String> GetListaTablic(){
		
    	List<String> regNumber = new ArrayList<String>();
		
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
		
	    try {
	    	
		    ResultSet namesList = stmt.executeQuery("SELECT [RegistrationNumber] FROM [krudzki_b].[dbo].[ClientCars]");
	    	while (namesList.next()) {
	    		regNumber.add(namesList.getString(1));
	    	}  

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (connection !=null) {
			System.out.print("Udalo sie");
		} else {
			System.out.print("UPS");
		}
		return regNumber;
	}

}