package org.uva.sea.ql.interpreter.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.interpreter.swing.panel.BlockPanel;
import org.uva.sea.ql.interpreter.swing.panel.IfStatementPanel;
import org.uva.sea.ql.interpreter.swing.panel.QuestionPanel;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class SwingVisitor implements ASTVisitor {
	private final JPanel panel;
	private Stack<JPanel> history;
	private SwingRegistry registry;

	public SwingVisitor() {
		this.panel = new JPanel();
		history = new Stack<>();
		history.push(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		registry = new SwingRegistry();
	}

	@Override
	public void visit(Form form) throws VisitorException {
		JPanel p = new JPanel();
		history.peek().add(p);
		form.getBlock().accept(this);
		createFunctions();
	}

	@Override
	public void visit(Block block) throws VisitorException {
		JPanel p = new BlockPanel(block);
		history.peek().add(p);
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
		for (QuestionPanel q : registry.getQuestions()) {
			Question question = q.getQuestion();
			if (question.getType() instanceof BooleanType) {
				JCheckBox c = (JCheckBox) q.getInput();
				c.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO validate user input
					}
				});
			}
			if (question.getType() instanceof Money) {
				JTextField t = (JTextField) q.getInput();
				t.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO validate user input
					}
				});
			}
			if (question.getType() instanceof StrType) {
				JTextField t = (JTextField) q.getInput();
				t.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO validate user input
					}
				});
			}
		}
		for (IfStatementPanel i : registry.getIfStatements()) {
			IfStatement ifStatement = i.getIfStatement();
			List<Ident> idents = ifStatement.getIdents();
			for (Ident ident : idents) {
				for (QuestionPanel q : registry.getQuestions()) {
					Question question = q.getQuestion();
					if (question.getIdent().getName().equals(ident.getName())) {
						if (question.getType() instanceof BooleanType) {
							JCheckBox c = (JCheckBox) q.getInput();
							c.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO evaluate if function
								}
							});
						}
						if (question.getType() instanceof Money) {
							JTextField t = (JTextField) q.getInput();
							t.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO evaluate if function
								}
							});
						}
						if (question.getType() instanceof StrType) {
							JTextField t = (JTextField) q.getInput();
							t.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO evaluate if function
								}
							});
						}
					}
				}
			}
		}
	}
}
