package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;

public class LineStatement extends Statement {

	private String lineName;
	private String displayText;

	public LineStatement(String string, Token st) {
		lineName = string;
		displayText = st.getText();
	}

	public void eval() {
		System.out.println(lineName + ":" + displayText);
	}

}
