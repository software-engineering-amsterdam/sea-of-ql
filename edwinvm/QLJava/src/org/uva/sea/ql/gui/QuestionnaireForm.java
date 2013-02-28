package org.uva.sea.ql.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.gui.render.GUIRenderer;
import org.uva.sea.ql.gui.render.State;

public class QuestionnaireForm {

	private JFrame _questionnaireFrame;
	
	public static void main(String[] args) { new QuestionnaireForm(); }
	
	public QuestionnaireForm() {
		renderQLForm();
	}
	
	private void renderQLForm() {
		renderQLStatements(getFormBody());
		setFormLayout();
	}
	
	private StatementBody getFormBody() {
		Form questionnaire = QuestionnaireHandler.getQuestionnaire();
		initializeForm(questionnaire.getName());
		return questionnaire.getBody();
	}
	
	private void renderQLStatements(StatementBody body) {
		for (FormStatement statement: body.getStatements()) {
			renderPanel(statement);
		}
	}
	private void renderPanel(FormStatement statement) {
		_questionnaireFrame.add(GUIRenderer.render(statement, new State()));
	}
	
	
	private void initializeForm(Identifier identifier) {
		_questionnaireFrame = new JFrame(identifier.getValue());
	}
	
	private void setFormLayout() {
		_questionnaireFrame.setSize(850,550);
		_questionnaireFrame.setLayout(new FlowLayout());
		_questionnaireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_questionnaireFrame.setVisible(true);
	}
	
}