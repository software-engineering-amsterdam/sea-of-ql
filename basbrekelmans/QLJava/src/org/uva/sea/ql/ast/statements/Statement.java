package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IStatementVisitor;
import org.uva.sea.ql.ast.Node;

public abstract class Statement extends Node {

	public Statement(ICodeLocationInformation info) {
		super(info);
	}
	
	public abstract void accept(IStatementVisitor visitor);
}
