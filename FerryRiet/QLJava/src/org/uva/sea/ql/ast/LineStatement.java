package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class LineStatement extends Statement {

	private final String lineName;
	private final String displayText;
	private final TypeDescription typeDescription ;

	public LineStatement(String string, Token st, TypeDescription ty) {
		lineName = string;
		displayText = st.getText();
		typeDescription = ty ;
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
	public String getLineName() {
		return lineName;
	}
	public String getDisplayText() {
		return displayText;
	}
	public TypeDescription getTypeDescription() {
		return typeDescription;
	}
	
}
