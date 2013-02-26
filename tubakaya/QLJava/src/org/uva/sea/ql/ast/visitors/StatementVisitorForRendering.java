package org.uva.sea.ql.ast.visitors;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.statements.ComputedValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;

public class StatementVisitorForRendering implements StatementVisitor{

	private JPanel parentPanel;
	public TypeVisitorForRendering typeVisitor;
	
	public StatementVisitorForRendering(JPanel parentPanel){
		this.typeVisitor = new TypeVisitorForRendering(parentPanel);
		this.parentPanel=parentPanel;
	}
	
	@Override
	public void visit(Form form) {
		for(Statement statement : form.getStatements())	{
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		addLabelInParentPanel(question.getText().value);
		question.getIdentifier().getType().accept(typeVisitor);
	}

	@Override
	public void visit(ComputedValue computedValue) {
		addLabelInParentPanel(computedValue.getText().value);
		computedValue.getIdentifier().getType().accept(typeVisitor);
	}

	@Override
	public void visit(IfStatement ifStatement) {
		for(Statement statement : ifStatement.getStatements())	{
			statement.accept(this);
		}
	}

	private void addLabelInParentPanel(String label) {		
		JLabel jLabel = new JLabel(label);
		parentPanel.add(jLabel, "w 280!, grow");		
	}
}
