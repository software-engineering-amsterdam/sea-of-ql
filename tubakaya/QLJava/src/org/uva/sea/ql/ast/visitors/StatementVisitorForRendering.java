package org.uva.sea.ql.ast.visitors;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.statements.ComputedValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.Type;

public class StatementVisitorForRendering implements StatementVisitor{

	private JPanel parentPanel;
	public TypeVisitorForRendering typeVisitor;
	private ExpressionTypeCheckingVisitor expressionTypeCheckingVisitor;
	
	public StatementVisitorForRendering(JPanel parentPanel,Map<Identifier, Type> identifierTypeMap){
		this.typeVisitor = new TypeVisitorForRendering(parentPanel);
		this.parentPanel=parentPanel;
		this.expressionTypeCheckingVisitor=new ExpressionTypeCheckingVisitor(identifierTypeMap);
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
		Type type=question.getIdentifier().accept(expressionTypeCheckingVisitor);
		type.accept(typeVisitor);
	}

	@Override
	public void visit(ComputedValue computedValue) {
		addLabelInParentPanel(computedValue.getText().value);
		Type type=computedValue.getIdentifier().accept(expressionTypeCheckingVisitor);
		type.accept(typeVisitor);
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
