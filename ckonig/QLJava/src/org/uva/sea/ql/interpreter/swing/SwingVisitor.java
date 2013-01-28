package org.uva.sea.ql.interpreter.swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.interpreter.swing.panel.BlockPanel;
import org.uva.sea.ql.interpreter.swing.panel.IfStatementPanel;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class SwingVisitor implements ASTVisitor {
	private final JPanel panel;
	private Stack<JPanel> history;
	private SwingRegistry registry;
	private List<InputValidator> inputValidators;
	private List<Evaluator> evaluators;

	public SwingVisitor() {
		this.panel = new JPanel();
		history = new Stack<>();
		history.push(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		registry = new SwingRegistry();
		inputValidators = new ArrayList<InputValidator>();
		evaluators = new ArrayList<Evaluator>();
	}

	@Override
	public void visit(Form form) throws VisitorException {
		history.peek().add(new JPanel());
		form.getBlock().accept(this);
		createFunctions();
	}

	@Override
	public void visit(Block block) throws VisitorException {
		history.peek().add(new BlockPanel(block));
		for (Expr e : block.getContent()) {
			if (e instanceof Question) {
				((Question) e).accept(this);
			}
			if (e instanceof IfStatement) {
				((IfStatement) e).accept(this);
			}
		}
	}

	@Override
	public void visit(Question question) throws VisitorException {
		QuestionPanel p = new QuestionPanel(question);
		history.peek().add(p);
		registry.addQuestion(p);
	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		IfStatementPanel p = new IfStatementPanel(ifStatement);
		p.setVisible(false);
		history.peek().add(p);
		history.push(p);
		registry.addIfStatement(p);
		ifStatement.getContent().accept(this);
		history.pop();
	}

	public JPanel getPanel() {
		return panel;
	}

	private void createFunctions() {
		for (QuestionPanel questionPanel : registry.getQuestions()) {
			inputValidators.add(new InputValidator(registry, questionPanel));
		}
		for (IfStatementPanel ifPanel : registry.getIfStatements()) {
			IfStatement ifStatement = ifPanel.getIfStatement();
			List<Ident> idents = ifStatement.getIdents();
			for (Ident ident : idents) {
				for (QuestionPanel questionPanel : registry.getQuestions()) {
					if (questionPanel.getIdentName().equals(ident.getName())) {
						evaluators.add(new Evaluator(registry, questionPanel));
					}
				}
			}
		}
	}
}
