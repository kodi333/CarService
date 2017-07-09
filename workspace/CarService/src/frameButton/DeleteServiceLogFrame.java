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

public class DeleteServiceLogFrame {
	
	private static ArrayList<JTextField> list = new ArrayList<JTextField>();
	
	public static String getList() {
		String clientID = list.get(0).getText();
		return clientID;
	}

	
	private static JComboBox<String> bookList = new JComboBox<String>();
	
	public static JComboBox<String> getBookList() {
		return bookList;
	}



	public static void main(String []args)
	{
		new DeleteServiceLogFrame();
	}
	
	
	public DeleteServiceLogFrame() {
		
		String[] labels = {"ID Logu: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel(new SpringLayout());
		
		
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			list.add(0,textField);
			l.setLabelFor(textField);
			p.add(textField);
		}
		
		JButton Submit = new JButtonConnect("Usun","DeleteServiceLog");
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
				2, 2, //rows, cols
				5, 5, //initialX, initialY
				5, 5);//xPad, yPad
		
		frame.add(p);
		frame.pack();
		frame.setTitle("Usun wpis logu");
		frame.setBounds(550, 200, 250, 110);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.add(panel);
		frame.setVisible(true);
	}




}