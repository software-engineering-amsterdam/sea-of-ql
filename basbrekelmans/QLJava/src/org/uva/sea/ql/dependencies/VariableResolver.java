package org.uva.sea.ql.dependencies;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.runtime.Variable;

public class VariableResolver implements IVariableResolver, IStatementVisitor {

	private IdentifierFinder identifierFinder = new IdentifierFinder();
	private List<Variable> variables;
	@Override
	public void visit(Form element) {
		element.getBody().accept(this);
	}

	@Override
	public void visit(If element) {
		addVariableFromExpression(element.getExpression(), null);
		element.getIfStatement().accept(this);
		if (element.getElseStatement() != null) {
			element.getElseStatement().accept(this);
		}		
	}

	private void addVariableFromExpression(Expression expr, Identifier identifier) {
		Variable expressionVariable;
		if (identifier == null) {
			expressionVariable = new Variable();
		} else {
			expressionVariable = new Variable(identifier);
		}
		for (Identifier dependency : identifierFinder.getDependency(expr)) {
			Variable dependantVariable = findVariableByIdentifier(dependency);
			if (dependantVariable == null) {
				//TODO: error list
				throw new RuntimeException();
			} else {
				expressionVariable.addDependency(dependantVariable);
			}			
		}
		variables.add(expressionVariable);
	}

	private Variable findVariableByIdentifier(Identifier dependency){
		for (Variable item : variables) {
			if (item.getIdentifier().equals(dependency)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public void visit(InputQuestion element) {
		variables.add(new Variable(element.getIdentifier()));
	}

	@Override
	public void visit(ComputedQuestion element) {
		addVariableFromExpression(element.getValue(), element.getIdentifier());
	}

	@Override
	public void visit(Statements element) {
		for (Statement statement : element) {
			statement.accept(this);
		}
	}

	@Override
	public Iterable<Variable> getVariables(Statement root) {
		this.variables = new ArrayList<Variable>();
		root.accept(this);
		return variables;
	}
}
