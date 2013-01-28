package org.uva.sea.ql.interpreter.swing;

import java.util.List;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.visitor.QLDocument;


public class SwingDocument implements QLDocument {
	private final JPanel panel;
	private Stack<JPanel> history;
	private SwingRegistry registry;

	public SwingDocument() {
		this.panel = new JPanel();
		history = new Stack<>();
		history.push(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		registry = new SwingRegistry();
	}

	@Override
	public Object getOutput() {
		return panel;
	}

	@Override
	public void setHeading(String content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void appendQuestion(Question question) {
		QuestionPanel p = new QuestionPanel(question);
		history.peek().add(p);
		registry.addQuestion(p);
	}

	@Override
	public void beginIf(IfStatement ifStatement) {
		IfStatementPanel p = new IfStatementPanel(ifStatement);
		p.setVisible(false);
		history.peek().add(p);
		history.push(p);
		registry.addIfStatement(p);

	}

	@Override
	public void endIf() {
		history.pop();
	}

	@Override
	public void create() {
		for (QuestionPanel questionPanel : registry.getQuestions()) {
			new AutoValueSetter(registry, questionPanel).createListeners();
		}
		QuestionListener questionListener = new QuestionListener(registry);
		for (IfStatementPanel ifPanel : registry.getIfStatements()) {
			IfStatement ifStatement = ifPanel.getIfStatement();
			List<Ident> idents = ifStatement.getIdents();
			for (Ident ident : idents) {
				questionListener.addIdentListener(ident);
			}
		}
	}

}
