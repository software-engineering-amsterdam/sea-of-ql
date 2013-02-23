package org.uva.sea.ql.ast.form;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Location;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class IfStatement extends AbstractConditional {
	private final List<ElseIfStatement> elseIfStatements;
	private final ElseStatement elseStatement;
	
	public IfStatement(Expr condition, Body body,
			List<ElseIfStatement> elseIfs, ElseStatement elseStatement,
			Location startLocation)
	{
		super(condition, body, startLocation);
		
		this.elseIfStatements = new ArrayList<>(elseIfs);
		this.elseStatement = elseStatement;
	}
	
	public List<ElseIfStatement> getElseIfs() {
		return new ArrayList<>(elseIfStatements);
	}
	
	public ElseStatement getElse() {
		return elseStatement;
	}
	
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Location getLocation() {
		Location endLocation;
		
		if (elseStatement != null) {
			endLocation = elseStatement.getLocation();
		} else if (elseIfStatements.size() > 0) {
			endLocation =
			elseIfStatements.get(elseIfStatements.size() - 1).getLocation();
		} else {
			endLocation = getBody().getLocation();
		}
		
		return new Location(super.getLocation(), endLocation);
	}

}
