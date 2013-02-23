package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.ASTVisitor;


public enum DataType implements ASTNode {

	BOOLEAN,
	INTEGER,
	MONEY,
	TEXT,
	UNDEF;

	@Override
	public void accept(ASTVisitor visitor) {
	}
	
}
