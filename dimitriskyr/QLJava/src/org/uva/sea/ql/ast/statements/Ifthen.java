package org.uva.sea.ql.ast.statements;
import org.uva.sea.ql.ast.*;
import java.util.*;

public class Ifthen extends Statement {
	private Expr expression;
	private List<Statement> block;
	
	public Ifthen (Expr expression, List<Statement> block){
		this.expression=expression;
		this.block = block;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	public List<Statement> getBlock() {
		return block;
	}

}
