package Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonConnect extends JButton {

	public JButtonConnect(String name, String nazwaFunkcji) {
		
		
		setText(name);
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
				
				Class<?> clazz = null;
				try {
					clazz = Class.forName("frameButton." + nazwaFunkcji);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Object obj = clazz.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//new Object();
			}
		});
		
	}


}
