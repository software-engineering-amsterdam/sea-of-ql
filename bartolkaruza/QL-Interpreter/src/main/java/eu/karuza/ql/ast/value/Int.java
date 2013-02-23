package eu.karuza.ql.ast.value;

import java.math.BigDecimal;


import eu.karuza.ql.ast.type.IntType;
import eu.karuza.ql.ast.type.Type;
import eu.karuza.ql.symbol.SymbolTable;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class Int extends Value {

	private static final long serialVersionUID = -7973914180102063923L;
	private Integer value;

	public Int(int lineNumber) {
		super(lineNumber);
		value = 0;
	}

	public Int(int lineNumber, String value) {
		super(lineNumber);
		this.value = Integer.parseInt(value);
	}

	public Int(int lineNumber, Integer value) {
		super(lineNumber);
		this.value = value;
	}
	
	@Override
	public Integer getRawValue() {
		return value;
	}
	
	@Override
	public void setValue(Object value) {
		if(!value.toString().equals("")) {
			this.value = Integer.valueOf(value.toString());
		} else {
			this.value = Integer.valueOf(0);
		}
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

	@Override
	public Type typeOf(SymbolTable symbolTable) {
		return new IntType();
	}

	@Override
	public Value add(Value value) {
		return value.addInt(this);
	}

	@Override
	public Value div(Value value) {
		return value.divInt(this);
	}

	@Override
	public Value eq(Value value) {
		return value.eqInt(this);
	}

	@Override
	public Value neq(Value value) {
		return value.neqInt(this);
	}

	@Override
	public Value geq(Value value) {
		return value.geqInt(this);
	}

	@Override
	public Value gt(Value value) {
		return value.gtInt(this);
	}

	@Override
	public Value leq(Value value) {
		return value.leqInt(this);
	}

	@Override
	public Value lt(Value value) {
		return value.ltInt(this);
	}

	@Override
	public Value neg() {
		return new Int(getLineNumber(), -getRawValue());
	}

	@Override
	public Value mul(Value value) {
		return value.mulInt(this);
	}

	@Override
	public Value pos() {
		return this;
	}

	@Override
	public Value sub(Value value) {
		return value.subInt(this);
	}

	@Override
	public Int addInt(Int value) {
		return new Int(getLineNumber(), this.value + value.getRawValue());
	}

	@Override
	public Int divInt(Int value) {
		return new Int(getLineNumber(), this.value / value.getRawValue());
	}

	@Override
	public Int mulInt(Int value) {
		return new Int(getLineNumber(), this.value * value.getRawValue() );
	}

	@Override
	public Int subInt(Int value) {
		return new Int(getLineNumber(), this.value - value.getRawValue());
	}

	@Override
	protected Bool eqInt(Int value) {
		return new Bool(getLineNumber(), this.value == value.getRawValue());
	}

	@Override
	protected Bool neqInt(Int value) {
		return new Bool(getLineNumber(), this.value != value.getRawValue());
	}

	@Override
	protected Bool geqInt(Int value) {
		return new Bool(getLineNumber(), this.value >= value.getRawValue());
	}

	@Override
	protected Bool gtInt(Int value) {
		return new Bool(getLineNumber(), this.value > value.getRawValue());
	}

	@Override
	protected Bool leqInt(Int value) {
		return new Bool(getLineNumber(), this.value <= value.getRawValue());
	}

	@Override
	protected Bool ltInt(Int value) {
		return new Bool(getLineNumber(), this.value < value.getRawValue());
	}

	@Override
	protected Money divMon(Money value) {
		Money thisMoney = new Money(getLineNumber(), new BigDecimal(getRawValue()));
		return new Money(getLineNumber(), ((Money) thisMoney.divMon(value)).getRawValue());
	}

	@Override
	protected Money addMon(Money value) {
		Money thisMoney = new Money(getLineNumber(), new BigDecimal(getRawValue()));
		return new Money(getLineNumber(), ((Money) thisMoney.addMon(value)).getRawValue());
	}

	@Override
	protected Money mulMon(Money value) {
		Money thisMoney = new Money(getLineNumber(), new BigDecimal(getRawValue()));
		return new Money(getLineNumber(), ((Money) thisMoney.mulMon(value)).getRawValue());
	}

	@Override
	protected Money subMon(Money value) {
		Money thisMoney = new Money(getLineNumber(), new BigDecimal(getRawValue()));
		return new Money(getLineNumber(), ((Money) thisMoney.subMon(value)).getRawValue());
	}

	@Override
	protected Bool eqMon(Money value) {
		return new Bool(getLineNumber(), value.getRawValue().compareTo(BigDecimal.valueOf(getRawValue())) == 0);
	}

	@Override
	protected Bool geqMon(Money value) {
		return new Bool(getLineNumber(), value.getRawValue().compareTo(BigDecimal.valueOf(getRawValue())) >= 0);
	}

	@Override
	protected Bool leqMon(Money value) {
		return new Bool(getLineNumber(), value.getRawValue().compareTo(BigDecimal.valueOf(getRawValue())) <= 0);
	}

	@Override
	protected Bool ltMon(Money value) {
		return new Bool(getLineNumber(), value.getRawValue().compareTo(BigDecimal.valueOf(getRawValue())) < 0);
	}

	@Override
	protected Bool neqMon(Money value) {
		return new Bool(getLineNumber(), value.getRawValue().compareTo(BigDecimal.valueOf(getRawValue())) > 0);
	}

}
