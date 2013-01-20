package org.uva.sea.ql.ast.statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uva.sea.ql.ICodeLocationInformation;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class BlockStatement extends Statement {

	private List<Statement> children;
	
	public BlockStatement(ICodeLocationInformation info) {
		super(info);
		children = new ArrayList<Statement>();
	}
	
	public BlockStatement(ICodeLocationInformation info, Statement... statements) {
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
