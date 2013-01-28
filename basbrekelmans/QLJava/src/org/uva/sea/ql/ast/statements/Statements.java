package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IStatementVisitor;

public class Statements extends Statement {

	private List<Statement> children;
	
	public Statements(ICodeLocationInformation info) {
		super(info);
		children = new ArrayList<Statement>();
	}
	
	public Statements(ICodeLocationInformation info, Iterable<Statement> statements) {
		super(info);
		children = new ArrayList<Statement>();
		for (Statement s : statements) {
			addChild(s);
		}
	}
	
	public Iterable<Statement> getChildren() {
		return children;
	}
	
	public void addChild(Statement child) {
		children.add(child);
	}
	
	@Override
	public void accept(IStatementVisitor visitor)  {
		visitor.visit(this);
	}
}
