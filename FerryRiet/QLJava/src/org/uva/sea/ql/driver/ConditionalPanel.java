package org.uva.sea.ql.driver;


import org.uva.sea.ql.ast.LineStatement;

public class ConditionalPanel extends Panel{
	private org.uva.sea.ql.ast.Expr trueExpr ;
	private boolean inverted;
	private boolean visible;
	public ConditionalPanel(LineStatement statement, org.uva.sea.ql.ast.Expr tEx, boolean inverted) {
		super(statement) ;
		
		trueExpr = tEx ;
		//visible = trueExpr.eval(symbolMap)
		
	}
}
