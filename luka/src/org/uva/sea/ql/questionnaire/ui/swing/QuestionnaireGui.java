package org.uva.sea.ql.questionnaire.ui.swing;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class QuestionnaireGui extends JFrame {

	private static final long serialVersionUID = 7744458377668041071L;

	private QuestionnaireGui(String name, JComponent mainPanel) {
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		this.getContentPane().add(scrollPane);
		setSize(800, 800);
		setLocation(300, 50);
		setName(name);
		setTitle(name);
		
	}

	public static void showGui(final String name, final JComponent mainPan) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new QuestionnaireGui(name, mainPan).setVisible(true);
			}
		});
	}
}
