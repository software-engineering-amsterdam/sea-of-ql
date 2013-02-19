package eu.karuza.ql.ast;


import eu.karuza.ql.ast.expr.grouping.Expr;
import eu.karuza.ql.ast.expr.type.Type;
import eu.karuza.ql.ast.expr.value.Value;
import eu.karuza.ql.visitor.StatementVisitor;

public class AnswerableQuestion extends Question {

	private static final long serialVersionUID = -3795111646031662993L;
	private Type type;
	private Value value;
	
	public AnswerableQuestion(String name, String label, Type type, int lineNumber) {
		super(name, label, lineNumber);
		this.type = type;
		this.value = type.getMatchingNode(lineNumber);
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public Expr getExpr() {
		return value;
	}

	@Override
	public void accept(StatementVisitor<?> visitor) {
		visitor.visit(this);
	}
	
	public void setValue(Object value) {
		this.value.setValue(value);
	}
	
	public Object getRawValue() {
		return value.getRawValue();
	}

}
