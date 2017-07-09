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

public class InsertClientFrame {
	
	private static ArrayList<JTextField> list = new ArrayList<JTextField>();
	
	
	public static ArrayList<JTextField> getList() {
		return list;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox bookList = new JComboBox(new Object[]{"Osoba fizyczna", "Firma", "Urzad Miasta"});
	
	public static JComboBox getBookList() {
		return bookList;
	}
	
	private static JComboBox categories = new JComboBox(new Object[]{"Osobowy", "Ciezarowy", "Van", "Specjalny"});
	
	public static JComboBox getCategories() {
		return categories;
	}


	public static void main(String []args)
	{
		new InsertClientFrame();
	}
	
	
	public InsertClientFrame() {
		
		String[] labels = {"Imie Klienta: ", "Nazwisko Klienta: ", "Adres klienta: ","Marka samochodu: ",
				"Numer rejetracyjny: ","Model: ","Kolor: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel(new SpringLayout());
		
		//clear the list of old data
		
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			list.add(i,textField);
			l.setLabelFor(textField);
			p.add(textField);
		}

		//add to the parent container (e.g. a JFrame):
		JLabel z = new JLabel("Kategoria Klienta: ");
		p.add(z);
		p.add(bookList);
		
		JLabel x = new JLabel("Typ samochodu: ");
		p.add(x);
		p.add(categories);

		//get the selected item:


		
		JButton Submit = new JButtonConnect("Wprowadz","SetNewClient");
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
				10, 2, //rows, cols
				5, 5, //initialX, initialY
				5, 5);//xPad, yPad
		
		frame.add(p);
		frame.pack();
		frame.setTitle("Wprowadz dane klienta");
		frame.setBounds(350, 100, 400, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.add(panel);
		frame.setVisible(true);
	}

}