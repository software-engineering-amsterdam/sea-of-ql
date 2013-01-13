package org.uva.sea.ql.ast;

import org.antlr.runtime.Token;
import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public class LineStatement extends Statement {

	public String lineName;
	public String displayText;
	public TypeDescription typeDescription ;

	public LineStatement(String string, Token st, TypeDescription ty) {
		lineName = string;
		displayText = st.getText();
		typeDescription = ty ;
	}
	public void eval() {
		System.out.print(lineName + ":" + displayText);
		typeDescription.eval() ;
		System.out.print("\n");
	}
	@Override
	public void accept(ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this) ;
	}
}
