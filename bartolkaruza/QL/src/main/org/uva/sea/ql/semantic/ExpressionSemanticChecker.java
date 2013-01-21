package org.uva.sea.ql.semantic;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.grouping.BinaryExpr;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.TextString;
import org.uva.sea.ql.error.ErrorHandler;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.symbol.Symbol;
import org.uva.sea.ql.symbol.SymbolTable;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class ExpressionSemanticChecker implements ExpressionVisitor{
	
	private static final String ADD = "+";
	private static final String AND = "&&";
	private static final String DIV = "/";
	private static final String GEQ = ">=";
	private static final String GT_ = ">";
	private static final String LEQ = "<=";
	private static final String LT_ = "<";
	private static final String MUL = "*";
	private static final String NEG = "--";
	private static final String NOT = "!";
	private static final String OR = "||";
	private static final String POS = "++";
	private static final String SUB = "-";
	private static final String EQ = "==";
	private static final String NEQ = "!=";
	
	private final SymbolTable table;
	private final ErrorHandler handler;
	private List<Symbol> symbols = new ArrayList<Symbol>();
	
	public ExpressionSemanticChecker(SymbolTable table, ErrorHandler handler) {
		this.table = table;
		this.handler = handler;
	}
	
	public List<Symbol> getSymbols() {
		return symbols;
	}
	
	public void clearSymbols() {
		this.symbols = new ArrayList<Symbol>();
	}
	
	@Override
	public void visit(Ident node) {
		
		if(table.hasSymbol(node.getName())) {
			Symbol symbol = table.getSymbol(node.getName());
			symbols.add(symbol);
			symbol.getVariable().accept(this);
		} else {
			handler.addError(new QLError("undefined variable: " + node.getName() + " at line: " + node.getLineNumber()));
		}
	}
	
	@Override
	public void visit(Add node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(ADD, node.getLineNumber());
		}
	}
	@Override
	public void visit(And node) {
		if(!areNodesBool(node)) {
			handler.reportOperationTypeError(AND, node.getLineNumber());
		}
	}
	@Override
	public void visit(Div node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(DIV, node.getLineNumber());
		}
	}
	@Override
	public void visit(Eq node) {
		if(!node.getLhs().typeOf(table).isCompatibleTo(node.getRhs().typeOf(table))) {
			handler.reportOperationTypeError(EQ, node.getLineNumber());
		}
	}
	@Override
	public void visit(GEq node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(GEQ, node.getLineNumber());
		}
	}
	@Override
	public void visit(GT node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(GT_, node.getLineNumber());
		}
	}
	@Override
	public void visit(LEq node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(LEQ, node.getLineNumber());
		}
	}
	@Override
	public void visit(LT node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(LT_, node.getLineNumber());
		}
	}
	@Override
	public void visit(Mul node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(MUL, node.getLineNumber());
		}
	}
	@Override
	public void visit(Neg node) {
		if(!node.getRhs().typeOf(table).isCompatibleToNumeric()) {
			handler.reportOperationTypeError(NEG, node.getLineNumber());
		}
	}
	@Override
	public void visit(NEq node) {
		if(!areNodesBool(node)) {
			handler.reportOperationTypeError(NEQ, node.getLineNumber());
		}
	}
	@Override
	public void visit(Not node) {
		if(!node.getRhs().typeOf(table).isCompatibleToBool()) {
			handler.reportOperationTypeError(NOT, node.getLineNumber());
		}
	}
	@Override
	public void visit(Or node) {
		if(!areNodesBool(node)) {
			handler.reportOperationTypeError(OR, node.getLineNumber());
		}
	}
	@Override
	public void visit(Pos node) {
		if(!node.getRhs().typeOf(table).isCompatibleToNumeric()) {
			handler.reportOperationTypeError(POS, node.getLineNumber());
		}
	}
	@Override
	public void visit(Sub node) {
		if(!areNodesNumeric(node)) {
			handler.reportOperationTypeError(SUB, node.getLineNumber());
		}
	}
	@Override
	public void visit(Bool node) {
		
	}
	@Override
	public void visit(Int node) {
		
	}
	@Override
	public void visit(Money node) {
		
	}
	@Override
	public void visit(TextString node) {
		
	}
	
	private boolean areNodesNumeric(BinaryExpr expr) {
		return expr.getLhs().typeOf(table).isCompatibleToNumeric() && expr.getRhs().typeOf(table).isCompatibleToNumeric();
	}
	
	private boolean areNodesBool(BinaryExpr expr) {
		return expr.getLhs().typeOf(table).isCompatibleToBool() && expr.getRhs().typeOf(table).isCompatibleToBool();
	}

}
