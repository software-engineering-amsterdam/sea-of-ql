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
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.Text;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.symbol.Symbol;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class ExpressionSemanticChecker implements ExpressionVisitor<Void> {

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
			symbols.add(symbol);
		} else {
			context.addError(new QLError("undefined variable: " + node.getName() + " at line: " + node.getLineNumber()));
		}
		return null;
	}

	@Override
	public Void visit(Add node) {
		if(!node.typeOf(context.getTable()).isCompatibleWithAdd()) {
			context.reportOperationTypeError(ADD, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(And node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithAnd()) {
			context.reportOperationTypeError(AND, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Div node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithDiv()) {
			context.reportOperationTypeError(DIV, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Eq node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithEq()) {
			context.reportOperationTypeError(EQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(GEq node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithGEq()) {
			context.reportOperationTypeError(GEQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(GT node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithGT()) {
			context.reportOperationTypeError(GT_, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(LEq node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithLEq()) {
			context.reportOperationTypeError(LEQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(LT node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithLT()) {
			context.reportOperationTypeError(LT_, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Mul node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithMul()) {
			context.reportOperationTypeError(MUL, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Neg node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithNeg()) {
			context.reportOperationTypeError(NEG, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(NEq node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithNEq()) {
			context.reportOperationTypeError(NEQ, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Not node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithNot()) {
			context.reportOperationTypeError(NOT, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Or node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithOr()) {
			context.reportOperationTypeError(OR, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Pos node) {
		if(!node.getLeastUpperBoundsType(context.getTable()).isCompatibleWithPos()) {
			context.reportOperationTypeError(POS, node.getLineNumber());
		}
		return null;
	}

	@Override
	public Void visit(Sub node) {
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
}
