package org.uva.sea.ql.ast.visitor;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.ConditionalStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.TypedStat;
import org.uva.sea.ql.ast.type.Type;

public class CheckStat implements StatementVisitor<Boolean>{
	
	//DEPENDS ON EXPRESSION CHECKER !
	private final Map<Ident,Type> typeEnv;
	
	public CheckStat( Map<Ident,Type> typeEnv){
		this.typeEnv = typeEnv;
	}
	
	public Boolean visit(ComputedStat stat) {
	     checkName(stat, stat.getExpr().typeOf(typeEnv));
	     checkExpr(stat.getExpr());
	     return true;
	}
	@Override
	public Boolean visit(AnswerableStat stat) {
		checkName(stat, stat.getType());
		return false;
	}

	@Override
	public Boolean visit(IfThenStat stat) {
		checkCondition(stat);
		  
		  return stat.getBody().accept(this);
	}

	private Boolean checkCondition(ConditionalStat stat) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Boolean visit(IfThenElseStat stat) {
		checkCondition(stat);
		  stat.getBody().accept(this);
		  stat.getElseBody().accept(this);
		  return false;
	}

	@Override
	public Boolean visit(Block stat) {
		 for (Stat s: stat.getStatements()) {
		     s.accept(this);
		}
		 return false;
	}
	
	private Boolean checkExpr(Expr expr) {
		// TODO Auto-generated method stub
		return false;
	}
	private Boolean checkName(TypedStat stat, Type typeOf) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
