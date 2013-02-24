package eu.karuza.ql.ast.statement;

import java.util.ArrayList;
import java.util.List;

import eu.karuza.ql.ast.Expr;
import eu.karuza.ql.ast.Statement;
import eu.karuza.ql.visitor.StatementVisitor;

public class IfElseConditionalStatement implements Statement {

	private static final long serialVersionUID = -3490822377073527135L;
	private List<Statement> ifStatements;
	private List<Statement> elseStatements;
	private Expr expr;
	private int lineNumber;
	private boolean visible;
	
	public IfElseConditionalStatement(Expr expression, List<Statement> ifStatements, List<Statement> elseStatements, int lineNumber) {
		this.ifStatements = ifStatements;
		this.elseStatements = elseStatements;
		this.expr = expression;
		this.lineNumber = lineNumber;
	}

	@Override
	public void accept(StatementVisitor<?> visitor) {
		visitor.visit(this);
	}

	public List<Statement> getElseStatements() {
		return elseStatements;
	}
	
	public List<Statement> getIfStatements() {
		return ifStatements;
	}
	
	public Expr getExpr() {
		return expr;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Statement> getAllStatements() {
		List<Statement> statements = new ArrayList<Statement>();
		statements.addAll(getIfStatements());
		statements.addAll(getElseStatements());
		return statements;
	}
}
