package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.types.QLType;

public class Identifier extends Simple {

	private final String name;
	private QLType type;
	
	public Identifier(ICodeLocationInformation codeLocation, String name) {
		super(codeLocation);
		this.name = name;
		this.type = null;
	}
	
	public Identifier(ICodeLocationInformation codeLocation, StringLiteral name, QLType type) {
		super(codeLocation);
		this.name = name.getValue();
		this.type = type;
	}
	public String getName() {
		return name;
	}

	@Override
	public QLType getType() {
		return type;
	}
	
	public void setType(QLType value)
	{
		this.type = value;
	}

}
