package org.uva.sea.ql.questionnaire.ui.swing;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.uva.sea.ql.questionnaire.Questionnaire;
import org.uva.sea.ql.questionnaire.state.State;
import org.uva.sea.ql.questionnaire.ui.swing.control.SaveButtonActionListener;

public class QuestionnaireGui extends JFrame {

	private static final long serialVersionUID = 7744458377668041071L;

	private QuestionnaireGui(Questionnaire questionnaire, State state,
			String fileSaveLocation) {
		// Initial settings
		setSize(800, 800);
		setLocation(300, 50);
		setTitle(questionnaire.getName());

		// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// Render Questions
		Box box = Box.createVerticalBox();
		box.add(SwingRenderer.renderStatement(questionnaire.getBlock(), state));
		box.add(Box.createRigidArea(new Dimension(0, 10)));

		// Save Button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveButtonActionListener(state,
				fileSaveLocation));
		box.add(saveButton);
		mainPanel.add(box);
		// ScrollPane
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		this.getContentPane().add(scrollPane);
	}

	public static void showGui(final Questionnaire questionnaire,
			final State state, final String fileSaveLocation) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new QuestionnaireGui(questionnaire, state, fileSaveLocation)
						.setVisible(true);
			}
		});
	}
}
