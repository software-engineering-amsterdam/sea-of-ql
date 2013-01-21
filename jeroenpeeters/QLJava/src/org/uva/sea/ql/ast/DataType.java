package org.uva.sea.ql.ast;

import org.uva.sea.ql.parser.ASTVisitor;

public enum DataType implements ASTNode {

	BOOLEAN,
	INTEGER,
	MONEY,
	TEXT;

	@Override
	public void accept(ASTVisitor visitor) {
	}
	
}
