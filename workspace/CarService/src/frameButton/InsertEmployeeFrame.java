package frameButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Buttons.JButtonConnect;
import layout.SpringUtilities;

public class InsertEmployeeFrame {
	
	private static ArrayList<JTextField> list = new ArrayList<JTextField>();
	
	public static ArrayList<JTextField> getList() {
		return list;
	}


	private static JComboBox bookList = new JComboBox(new Object[]{"Junior Serviceman", "Serviceman", "Senior Serviceman" ,"Team Leader"});
	
	public static JComboBox getBookList() {
		return bookList;
	}


	public static void main(String []args)
	{
		new InsertEmployeeFrame();
	}
	
	
	public InsertEmployeeFrame() {
		
		String[] labels = {"Imie Pracownika: ", "Nazwisko Pracownika: ", "Adres Pracownika: ","Pesel Pracownika: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel(new SpringLayout());
		
		
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			list.add(i,textField);
			l.setLabelFor(textField);
			p.add(textField);
		}
		
		 
//		// create a combo box with the fixed array:
//		bookList.addItem("Junior Serviceman");
//		bookList.addItem("Serviceman");
//		bookList.addItem("Senior Serviceman");
		
		
//		JComboBox<String> bookList = new JComboBox<>(bookTitles);

		//add to the parent container (e.g. a JFrame):
		JLabel z = new JLabel("Stanowisko: ");
		p.add(z);
		p.add(bookList);

		//get the selected item:


		
		JButton Submit = new JButtonConnect("Wprowadz","SetNewEmployee");
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
				6, 2, //rows, cols
				5, 5, //initialX, initialY
				5, 5);//xPad, yPad
		
		frame.add(p);
		frame.pack();
		frame.setTitle("Wprowadz dane pracownika");
		frame.setBounds(550, 200, 300, 240);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.add(panel);
		frame.setVisible(true);
	}

}