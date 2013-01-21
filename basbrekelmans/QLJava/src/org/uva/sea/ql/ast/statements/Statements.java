package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uva.sea.ql.ICodeLocationInformation;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class Statements extends Statement {

	private List<Statement> children;
	
	public Statements(ICodeLocationInformation info) {
		super(info);
		children = new ArrayList<Statement>();
	}
	
	public Statements(ICodeLocationInformation info, Statement... statements) {
		super(info);
		children = Arrays.asList(statements);
	}
	
	public Iterable<Statement> getChildren() {
		return children;
	}
	
	public void addChild(Statement child) {
		children.add(child);
	}
}
