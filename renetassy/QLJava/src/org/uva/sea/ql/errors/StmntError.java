package org.uva.sea.ql.errors;

import org.uva.sea.ql.ast.stmnt.Statement;

public class StmntError extends QLError {
	
	//private Statement stmnt;
	private String msg;
	
	public StmntError (String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}

	@Override
	public void accept(QLErrorPrinter visitor) {
		visitor.visit(this);
	}

}
