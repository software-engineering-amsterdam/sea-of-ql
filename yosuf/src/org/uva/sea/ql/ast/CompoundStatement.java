package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement implements ASTNode {

	public CompoundStatement(final ASTNode astNode) {

	}

	List<Statement> statements = new ArrayList<Statement>();

	public void addStatement(final ASTNode astNode) {

	}
}
