package eu.karuza.ql.ast;


import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.ast.value.Value;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public abstract class Expr implements ASTNode {

	private static final long serialVersionUID = 7753425914366624367L;
	private int lineNumber;

	protected Expr(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public abstract Type typeOf(SymbolTable symbolTable);

	protected abstract Type getLeastUpperBoundsType(SymbolTable table);
	
	public abstract boolean isCompatibleToType(Type type, SymbolTable table);

	public abstract void accept(ExpressionVisitor<?> visitor);

	public abstract Value evaluate();

}
