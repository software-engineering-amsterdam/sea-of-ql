package eu.karuza.ql.visitor.impl;

import java.util.ArrayList;
import java.util.List;


import eu.karuza.ql.ast.BinaryExpr;
import eu.karuza.ql.ast.UnaryExpr;
import eu.karuza.ql.ast.expr.Add;
import eu.karuza.ql.ast.expr.And;
import eu.karuza.ql.ast.expr.Div;
import eu.karuza.ql.ast.expr.Eq;
import eu.karuza.ql.ast.expr.GEq;
import eu.karuza.ql.ast.expr.GT;
import eu.karuza.ql.ast.expr.LEq;
import eu.karuza.ql.ast.expr.LT;
import eu.karuza.ql.ast.expr.Mul;
import eu.karuza.ql.ast.expr.NEq;
import eu.karuza.ql.ast.expr.Neg;
import eu.karuza.ql.ast.expr.Not;
import eu.karuza.ql.ast.expr.Or;
import eu.karuza.ql.ast.expr.Pos;
import eu.karuza.ql.ast.expr.Sub;
import eu.karuza.ql.ast.value.Bool;
import eu.karuza.ql.ast.value.Ident;
import eu.karuza.ql.ast.value.Int;
import eu.karuza.ql.ast.value.Money;
import eu.karuza.ql.ast.value.Text;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.symbol.Symbol;
import eu.karuza.ql.visitor.ExpressionVisitor;

public class ExpressionSemanticChecker implements ExpressionVisitor<Void> {

	private static final String ADD = "+";
	private static final String AND = "&&";
	private static final String DIV = "/";
	private static final String GEQ = ">=";
	private static final String GRT = ">";
	private static final String LEQ = "<=";
	private static final String LST = "<";
	private static final String MUL = "*";
	private static final String NEG = "--";
	private static final String NOT = "!";
	private static final String OR = "||";
	private static final String POS = "++";
	private static final String SUB = "-";
	private static final String EQ = "==";
	private static final String NEQ = "!=";

	private final ParserContext context;

	private List<Symbol> symbols = new ArrayList<Symbol>();

	public ExpressionSemanticChecker(ParserContext context) {
		this.context = context;
	}

	public List<Symbol> getSymbols() {
		return symbols;
	}

	public void clearSymbols() {
		this.symbols = new ArrayList<Symbol>();
	}

	@Override
	public Void visit(Ident node) {
		if (context.hasSymbol(node.getName())) {
			Symbol symbol = context.getSymbol(node.getName());
			node.setExpr(symbol.getExpr());
			symbols.add(symbol);
		} else {
			context.addError(new QLError("undefined variable: " + node.getName() + " at line: " + node.getLineNumber()));
		}
		return null;
	}

	@Override
	public Void visit(Add node) {
		acceptBinary(node);
		if(!node.typeOf(context.getTable()).isCompatibleWithAdd()) {
			context.reportOperationTypeError(ADD, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(And node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithAnd()) {
			context.reportOperationTypeError(AND, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Div node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithDiv()) {
			context.reportOperationTypeError(DIV, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Eq node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithEq()) {
			context.reportOperationTypeError(EQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(GEq node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithGEq()) {
			context.reportOperationTypeError(GEQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(GT node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithGT()) {
			context.reportOperationTypeError(GRT, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(LEq node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithLEq()) {
			context.reportOperationTypeError(LEQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(LT node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithLT()) {
			context.reportOperationTypeError(LST, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Mul node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithMul()) {
			context.reportOperationTypeError(MUL, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Neg node) {
		acceptUnary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithNeg()) {
			context.reportOperationTypeError(NEG, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(NEq node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithNEq()) {
			context.reportOperationTypeError(NEQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Not node) {
		acceptUnary(node);
		node.getRhs().accept(this);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithNot()) {
			context.reportOperationTypeError(NOT, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Or node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithOr()) {
			context.reportOperationTypeError(OR, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Pos node) {
		acceptUnary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithPos()) {
			context.reportOperationTypeError(POS, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Sub node) {
		acceptBinary(node);
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithSub()) {
			context.reportOperationTypeError(SUB, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Bool node) {
		return null;
	}

	@Override
	public Void visit(Int node) {
		return null;
	}

	@Override
	public Void visit(Money node) {
		return null;
	}

	@Override
	public Void visit(Text node) {
		return null;
	}
	
	private void acceptBinary(BinaryExpr expr) {
		expr.getLhs().accept(this);
		expr.getRhs().accept(this);
	}
	
	private void acceptUnary(UnaryExpr expr) {
		expr.getRhs().accept(this);
	}
}
