package khosrow.uva.sea.ql.visitor.check;

import khosrow.uva.sea.ql.ast.stmt.Assign;
import khosrow.uva.sea.ql.ast.stmt.ExpressionQuestion;
import khosrow.uva.sea.ql.ast.stmt.If;
import khosrow.uva.sea.ql.ast.stmt.Label;
import khosrow.uva.sea.ql.ast.stmt.SimpleQuestion;
import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class StmtTypeChecker implements IStmtVisitor {

	@Override
	public void visit(Assign stmt) {
		// TODO Auto-generated method stub
		// check if ident does exist in the env!!
		
	}

	@Override
	public void visit(If stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExpressionQuestion stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SimpleQuestion stmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Label stmt) {
		// TODO Auto-generated method stub
		
	}

	

}
