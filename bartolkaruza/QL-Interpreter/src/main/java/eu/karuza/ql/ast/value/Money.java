package eu.karuza.ql.ast.value;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


import eu.karuza.ql.ast.type.MoneyType;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Money extends Value {

	private static final long serialVersionUID = 2961628854635271879L;
	private BigDecimal value;
	public static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);

	public Money(int lineNumber) {
		super(lineNumber);
		this.value = BigDecimal.valueOf(0);
		this.value.setScale(2, RoundingMode.HALF_EVEN);
	}

	public Money(int lineNumber, String initialValue) {
		super(lineNumber);
		this.value = new BigDecimal(initialValue);
		this.value.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public Money(int lineNumber, BigDecimal value) {
		super(lineNumber);
		this.value = value;
		this.value.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public Money(int lineNumber, Int value) {
		super(lineNumber);
		this.value = BigDecimal.valueOf(value.getRawValue());
		this.value.setScale(2, RoundingMode.HALF_EVEN);
	}

	@Override
	public BigDecimal getRawValue() {
		return value;
	}
	
	@Override
	public void setValue(Object value) {
		this.value = new BigDecimal(value.toString());
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new MoneyType();
	}
	
	@Override
	public Value add(Value value) {
		return value.addMon(this);
	}
	
	@Override
	public Value div(Value value) {
		return value.divMon(this);
	}
	
	@Override
	public Value geq(Value value) {
		return value.geqMon(this);
	}
	
	@Override
	public Value eq(Value value) {
		return value.eqMon(this);
	}
	
	@Override
	public Value gt(Value value) {
		return value.gtMon(this);
	}
	
	@Override
	public Value leq(Value value) {
		return value.leqMon(this);
	}
	
	@Override
	public Value lt(Value value) {
		return value.ltMon(this);
	}
	
	@Override
	public Value mul(Value value) {
		return value.mulMon(this);
	}
	
	@Override
	public Value neq(Value value) {
		return value.neqMon(this);
	}
	
	@Override
	public Money neg() {
		return new Money(getLineNumber(), getRawValue().negate());
	}
	
	@Override
	public Money pos() {
		return this;
	}
	
	@Override
	public Value sub(Value value) {
		return value.subMon(this);
	}
	
	@Override
	protected Value addMon(Money value) {
		return new Money(getLineNumber(), getRawValue().add(value.getRawValue()));
	}
	
	@Override
	protected Money subMon(Money value) {
		return new Money(getLineNumber(), getRawValue().subtract(value.getRawValue()));
	}
	
	@Override
	protected Money divMon(Money value) {
		return new Money(getLineNumber(), getRawValue().divide(value.getRawValue()));
	}
	
	@Override
	protected Bool eqMon(Money value) {
		return new Bool(getLineNumber(), getRawValue().compareTo(value.getRawValue()) == 0);
	}
	
	@Override
	protected Bool geqMon(Money value) {
		return new Bool(getLineNumber(), getRawValue().compareTo(value.getRawValue()) >= 0);
	}
	
	@Override
	protected Bool gtMon(Money value) {
		return new Bool(getLineNumber(), getRawValue().compareTo(value.getRawValue()) > 0);
	}
	
	@Override
	protected Bool leqMon(Money value) {
		return new Bool(getLineNumber(), getRawValue().compareTo(value.getRawValue()) <= 0);
	}
	
	@Override
	protected Bool ltMon(Money value) {
		return new Bool(getLineNumber(), getRawValue().compareTo(value.getRawValue()) < 0);
	}
	
	@Override
	protected Bool neqMon(Money value) {
		return new Bool(getLineNumber(), getRawValue().compareTo(value.getRawValue()) != 0);
	}
	
	@Override
	protected Money mulMon(Money value) {
		return new Money(getLineNumber(), getRawValue().multiply(value.getRawValue()));
	}
	
	@Override
	protected Value addInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return addMon(money);
	}
	
	@Override
	protected Money divInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return divMon(money);
	}
	
	@Override
	protected Bool eqInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return eqMon(money);
	}
	
	@Override
	protected Bool geqInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return geqMon(money);
	}
	
	@Override
	protected Bool gtInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return gtMon(money);
	}
	
	@Override
	protected Bool leqInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return leqMon(money);
	}
	
	@Override
	protected Bool ltInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return ltMon(money);
	}
	
	@Override
	protected Money mulInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return mulMon(money);
	}
	
	@Override
	protected Bool neqInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return neqMon(money);
	}
	
	@Override
	protected Money subInt(Int value) {
		Money money = new Money(getLineNumber(), value);
		return subMon(money);
	}
}
