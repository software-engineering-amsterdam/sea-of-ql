package org.uva.sea.ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.gui.observe.State;
import org.uva.sea.ql.gui.render.QuestionnaireRenderer;

public class QuestionnaireForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private State _state;
	
	public static void main(String[] args) { new QuestionnaireForm(); }
	
	public QuestionnaireForm() {
		renderQuestionnaireForm();
	}
	
	private void renderQuestionnaireForm() {
		renderStatements(getFormBody());
		setFormLayout();
	}
	
	private StatementBody getFormBody() {
		Form questionnaire = QuestionnaireHandler.getQuestionnaire();
		initializeForm(questionnaire.getName());
		return questionnaire.getBody();
	}
	
	private void renderStatements(StatementBody body) {
		initializeQuestionnaireState();
		renderPanel(body);
	}
	
	private void renderPanel(StatementBody body) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new MigLayout("wrap"));
		for (JPanel panel: render(body)) {
			mainPanel.add(panel, "wrap");
		}
		add(mainPanel);
	}
	
	private ArrayList<JPanel> render(StatementBody body) {
		return QuestionnaireRenderer.render(body, _state);
	}
	
	private void initializeQuestionnaireState() {
		_state = new State(QuestionnaireHandler.getTypeEnvironment());
	}
	
	private void initializeForm(Identifier formName) {
		setTitle(formName.getValue());
	}
	
	private void setFormLayout() {
		setSize(850,550);
		setLayout(new MigLayout("wrap 1"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		enableCloseOnEscape();
	}

	private void enableCloseOnEscape() {
		ActionListener escListener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { dispose(); }
	    };
	    getRootPane().registerKeyboardAction(escListener,
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW
        );
	}
	
}