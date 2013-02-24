package org.uva.sea.ql.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		initUI();
	}
	
	public final void initUI() {

       JPanel panel = new JPanel(new MigLayout("hidemode 3"));
       getContentPane().add(panel);

       final JPanel list1 = new JPanel(new MigLayout());
       JButton button = new JButton();
       button.addActionListener(new ActionListener() {
    	   private boolean visible = false;
			@Override
			public void actionPerformed(ActionEvent e) {
				list1.setVisible(visible = !visible);
			}
       });
       panel.add(button, "wrap");
       JLabel label1 = new JLabel("label 1");
       JTextField text1 = new JTextField(20);
       list1.add(label1);
       list1.add(text1);
       panel.add(list1, "wrap");
       list1.setVisible(false);
       
       JLabel label2 = new JLabel("label 2");
       JLabel label3 = new JLabel("label 3");
       JLabel label4 = new JLabel("label 4");
       JLabel label5 = new JLabel("label 5");
       
       panel.add(label2, "wrap");
       panel.add(label3, "");
       panel.add(label4, "");
       panel.add(label5, "");

       setTitle("Window title, woohoo!");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }
}
