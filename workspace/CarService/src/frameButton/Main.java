package frameButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import Buttons.JButtonConnect;
	
	public class Main {
		private static String test1;
		Main() 
		{
		
		JFrame ramka = new JFrame();
		
		JPanel mainPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel(new BorderLayout());
		JPanel rightTopPanel = new JPanel(new GridLayout(4,1));
		JPanel rightBottomPanel = new JPanel(new GridLayout(4,2));
		JPanel rightMiddlePanel = new JPanel();
		rightMiddlePanel.setSize(100, 10);

		JButton buttonAddLog = new JButtonConnect("Dodaj Wpis Serwisowy","InsertServicesLog");
		JButton buttonDeleteLog = new JButtonConnect("Usun Wpis Serwisowy","DeleteServiceLogFrame");
		
		JButton buttonAddClient = new JButtonConnect("Dodaj klienta","InsertClientFrame");
		JButton buttonDeleteClient = new JButtonConnect("Usun klienta","DeleteClientNameFrame");
		
		JButton buttonAddEmplyee = new JButtonConnect("Dodaj pracownika","InsertEmployeeFrame");
		JButton buttonDeleteEmployee = new JButtonConnect("Usun pracownika","DeleteEmployeeFrame");
		
		
		JButton buttonCarsServiced = new JButtonConnect("Obecnie Obslugiwane Pojazdy","GetObslugiwanePojazdy");
		JButton buttonEmployeeList = new JButtonConnect("Lista Pracownikow","GetListaPracownikow");
		JButton buttonClientsList = new JButtonConnect("Lista Klientow","GetListaKlientow");
		JButton buttonServicesList = new JButtonConnect("Cennik Uslug","GetListaUslug");
		JButton buttonServicesLog = new JButtonConnect("Log Serwisowy","GetLogNapraw");
		JButton buttonClientCars = new JButtonConnect("Pojazdy Klientow","GetSamochodyKlientow");
		JButton buttonDeleteClientCar = new JButtonConnect("Usun Pojazd","DeleteClientCarFrame");
		JButton buttonChangeLog = new JButtonConnect("Log Zmian","GetChangeLog");
		JButton buttonClearChangeLog = new JButtonConnect("Wyczysc Log Zmian","ClearChangeLog");
		

		
		//add image
		ImageIcon image = new javax.swing.ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/car.jpg")));
		JLabel imageLabel = new JLabel("", image, JLabel.HORIZONTAL);
		
		leftPanel.add(imageLabel);
		rightPanel.add(rightTopPanel,BorderLayout.NORTH);
		
		JSeparator separator = new JSeparator();
		
		rightPanel.add(rightBottomPanel,BorderLayout.SOUTH);
		
		rightTopPanel.add(buttonAddLog);
		rightTopPanel.add(buttonDeleteLog);
		
		rightTopPanel.add(buttonAddClient);
		rightTopPanel.add(buttonDeleteClient);
		
		rightTopPanel.add(buttonAddEmplyee);
		rightTopPanel.add(buttonDeleteEmployee);
		
		rightBottomPanel.add(buttonCarsServiced);
		rightBottomPanel.add(buttonEmployeeList);
		rightBottomPanel.add(buttonClientsList);
		rightBottomPanel.add(buttonServicesList);
		rightBottomPanel.add(buttonServicesLog);
		rightBottomPanel.add(buttonClientCars);
		rightBottomPanel.add(buttonDeleteClientCar);
		rightBottomPanel.add(buttonChangeLog);
		rightBottomPanel.add(buttonClearChangeLog);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(leftPanel);
		mainPanel.add(rightPanel);
		
		//panel.setLayout(new GridLayout(2,2));
		
		ramka.getContentPane().add(mainPanel);

		ramka.pack();
		ramka.setResizable(false);
		ramka.setTitle("Panel Obs³ugi Serwisu Samochodowego");
		ramka.setLocation(200, 200);
		ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//ramka.add(panel);
		ramka.setVisible(true);
		
		test1 = buttonAddClient.getText();
		
		}
		
		public static void main(String []args)
		{
			new Main();
//			System.out.print(Main.test1);
		}
		
	}

