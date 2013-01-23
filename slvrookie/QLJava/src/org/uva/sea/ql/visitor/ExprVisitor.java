package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.ast.types.Type;

public class ExprVisitor implements IVisitor<Boolean> {
	
	private Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	private final List<String> messages = new ArrayList<String>();

	
	public void addError(String error) {
		this.messages.add(error);
	}
	
	public List<String> getErrorList() {
		return messages;
	}


	@Override
	public Boolean visit(Ident node) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Boolean visit(Add node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,"+");	
		return true;
	}

	@Override
	public Boolean visit(And node) {
		checkSubtrees(node);
		areBothSidesCompatibleToBoolean(node, "&&");
		return true;
	}

	@Override
	public Boolean visit(Div node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,"/");
		return true;
	}
	
	@Override
	public Boolean visit(Eq node) {
		checkSubtrees(node);
		areBothSidesSameType(node, "==");
		return true;
	}

	@Override
	public Boolean visit(GEq node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,">=");
		return true;
	}

	@Override
	public Boolean visit(GT node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,">");
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,"<=");
		return true;
	}

	@Override
	public Boolean visit(LT node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,"<");
		return true;
	}

	@Override
	public Boolean visit(Mul node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,"*");
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		checkArgument(node);
		isArgumentNumeric(node, "-");
		return true;
	}

	@Override
	public Boolean visit(NEq node) {
		checkSubtrees(node);		
		areBothSidesSameType(node, "!=");
		return true;
	}

	@Override
	public Boolean visit(Not node) {
		checkArgument(node);
		isArgumentBoolean(node, "!");
		return true;
	}

	@Override
	public Boolean visit(Or node) {
		checkSubtrees(node);
		areBothSidesCompatibleToBoolean(node, "||");
		return true;
	}

	@Override
	public Boolean visit(Pos node) {
		checkArgument(node);
		isArgumentNumeric(node, "+");
		return true;
	}

	@Override
	public Boolean visit(Sub node) {
		checkSubtrees(node);
		areBothSidesCompatibleToNumeric(node,"-");
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(MoneyLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
	}
	
	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}
	
	private boolean checkSubtrees(BinaryExpr node){
		if (!(node.getLhs().accept(this) && node.getRhs().accept(this)));	
		return false;	
	}
	
	private boolean checkArgument(UnaryExpr node){
		if (!node.getArg().accept(this));
		return false;
	}
	
	private boolean isArgumentNumeric(UnaryExpr node, String operator){
		if(!node.getArg().typeOf(typeEnv).isCompatibleToNumeric()) {
			addError("Invalid type for unary" + operator);
		}
		return false;
	}
	
	private boolean isArgumentBoolean(UnaryExpr node, String operator){
		if(!node.getArg().typeOf(typeEnv).isCompatibleToBoolType()) {
			addError("Invalid type for unary" + operator);
		}
		return false;
	}
	
	private boolean areBothSidesSameType(BinaryExpr node, String operator) {
		if (!(node.getLhs().typeOf(typeEnv).isCompatibleTo(node.getRhs().typeOf(typeEnv)))){
			addError("Both operators must have the same type for" + operator);
		}
		return false;
	}
	
	private boolean areBothSidesCompatibleToNumeric(BinaryExpr node, String operator ) {
		if (!(node.getLhs().typeOf(typeEnv).isCompatibleToNumeric() && node.getRhs().typeOf(typeEnv).isCompatibleToNumeric())){
			addError("invalid type for " + operator);
		}
		return false;
	}
	
	private boolean areBothSidesCompatibleToBoolean(BinaryExpr node, String operator ) {
		if (!(node.getLhs().typeOf(typeEnv).isCompatibleToBoolType() && node.getRhs().typeOf(typeEnv).isCompatibleToBoolType())){
			addError("invalid type for " + operator);
		}
		return false;
	}

}