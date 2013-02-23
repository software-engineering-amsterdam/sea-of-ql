package eu.karuza.ql.ast.value;


import eu.karuza.ql.ast.type.TextType;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Text extends Value {

	private static final long serialVersionUID = -2686137921702760938L;
	private String value;

	public Text(int lineNumber) {
		super(lineNumber);
		this.value = "";
	}

	public Text(int lineNumber, String initialValue) {
		super(lineNumber);
		this.value = initialValue;
	}
	
	@Override
	public void setValue(Object value) {
		this.value = value.toString();
	}
	
	@Override
	public String getRawValue() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new TextType();
	}
	
	@Override
	public Value add(Value value) {
		return value.addString(this);
	}
	
	@Override
	public Value eq(Value value) {
		return value.eqString(this);
	}
	
	@Override
	protected Text addString(Text value) {
		return new Text(getLineNumber(), concatString(value));
	}
	
	@Override
	protected Bool eqString(Text value) {
		return new Bool(getLineNumber(), value.getRawValue().equals(getRawValue()));
	}
	
	@Override
	protected Value addMon(Money value) {
		return new Text(getLineNumber(), concatString(value));
	}
	
	@Override
	protected Value addInt(Int value) {
		return new Text(getLineNumber(), concatString(value));
	}
	
	@Override
	protected Value addBool(Bool value) {
		return new Text(getLineNumber(), concatString(value));
	}
	
	private String concatString(Value value) {
		return getRawValue() + " " + value.getRawValue();
	}
}
