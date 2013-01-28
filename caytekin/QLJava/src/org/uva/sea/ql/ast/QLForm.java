package org.uva.sea.ql.ast;

import java.util.ArrayList;

public class QLForm implements ASTNode {
	
	private final String formId;
	private final ArrayList<Statement> stmtList;
	
	public QLForm (String formId, ArrayList<Statement> stmtList) {
		this.formId = formId;
		this.stmtList = stmtList;
	}


}
