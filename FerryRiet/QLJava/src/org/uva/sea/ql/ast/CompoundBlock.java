package org.uva.sea.ql.ast;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CompoundBlock {
	private List<Statement> statementList = new ArrayList<Statement>();

	public CompoundBlock() {
		System.out.println("----------------Started Compound");
	}

	public void addStatement(Statement st) {
		System.out.println("Adding statements to Compound");
		statementList.add(st);
	}

	public void eval() {

		Iterator<Statement> it = statementList.iterator();

		System.out.println("{{{{{{{{{{");
		while (it.hasNext()) {
			Statement value = (Statement) it.next();
			value.eval() ;
		}
		System.out.println("}}}}}}}}}}}");
	}
}
