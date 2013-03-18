package org.uva.sea.ql.form.input;

import org.uva.sea.ql.ast.nodes.statements.Statement;

public class InputState {
	private Statement parsedResult;
	public InputState(){}
	public void setParsedStatement(Statement parsed){
		this.parsedResult = parsed;
	}
	public Statement getParsedStatement(){
		return this.parsedResult;
	}
}
