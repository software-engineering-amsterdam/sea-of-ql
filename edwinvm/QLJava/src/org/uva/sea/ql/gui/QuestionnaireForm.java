package org.uva.sea.ql.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.gui.render.GUIRenderer;
import org.uva.sea.ql.gui.render.State;

public class QuestionnaireForm {

	private JFrame _questionnaireFrame;
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
		_questionnaireFrame.add(render(body));
	}
	
	private JPanel render(StatementBody body) {
		return GUIRenderer.render(body, _state);
	}
	
	private void initializeQuestionnaireState() {
		_state = new State(QuestionnaireHandler.getTypeEnvironment());
	}
	
	private void initializeForm(Identifier formName) {
		_questionnaireFrame = new JFrame(formName.getValue());
	}
	
	private void setFormLayout() {
		_questionnaireFrame.setSize(850,550);
		_questionnaireFrame.setLayout(new FlowLayout());
		_questionnaireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_questionnaireFrame.setVisible(true);
		enableCloseOnEscape();
	}

	private void enableCloseOnEscape() {
		ActionListener escListener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) { _questionnaireFrame.dispose(); }
	    };
	    _questionnaireFrame.getRootPane().registerKeyboardAction(escListener,
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW
        );
	}
	
}