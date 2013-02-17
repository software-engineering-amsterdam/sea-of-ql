package ast.visitor;

import java.util.Iterator;

import ast.Form;
import ast.Statement;
import ast.expression.*;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.*;
import ast.statement.*;
import ast.type.Message;
import ast.type.Numeric;

public class PrintExpressionVisitor implements Visitor<Boolean> {

	private int depth = 0;

	public PrintExpressionVisitor() {
		super();
		System.out.println("EXPR VISITOR");
	}

	public PrintExpressionVisitor(int depth) {
		super();
		this.depth = depth;
		print();
	}

	@Override
	public Boolean visit(Add ast) {
		System.out.println("EXPR ADD");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		System.out.println("EXPR AND");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		System.out.println("EXPR DIV");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		System.out.println("EXPR EQ");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		System.out.println("EXPR GEQ");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		System.out.println("EXPR GT");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		System.out.println("EXPR LEQ");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		System.out.println("EXPR LT");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		System.out.println("EXPR MUL");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		System.out.println("EXPR NEG");
		this.unaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		System.out.println("EXPR NEQ");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		System.out.println("EXPR NOT");
		this.unaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		System.out.println("EXPR OR");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		System.out.println("EXPR POS");

		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		System.out.println("EXPR SUB");
		this.binaryVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Bool ast) {
		System.out.print("EXPR BOOL: ");
		this.valueVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Str ast) {
		System.out.print("EXPR STR: ");
		this.valueVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Money ast) {
		System.out.print("EXPR MONEY: ");
		this.valueVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		System.out.print("EXPR INT: ");
		this.valueVisit(ast);
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		System.out.print("EXPR IDENT: ");
		this.valueVisit(ast);
		return true;
	}

	public void binaryVisit(Binary ast) {
		ast.getLhs().accept(new PrintExpressionVisitor(depth+1));
		ast.getRhs().accept(new PrintExpressionVisitor(depth+1));
	}

	public void unaryVisit(Unary ast) {
		ast.getExpression().accept(new PrintExpressionVisitor(depth+1));
	}

	public void valueVisit(Value ast) {
		System.out.println(ast.toString());
		System.out.println("XXX");
	}

	public void print() {
		for (int i = 0; i < (depth - 1); i++)
			System.out.print('|');
		System.out.print('-');
	}

	@Override
	public Boolean visit(Assignment ast) {
		System.out.print("STAT ASSIGNMENT ");
		System.out.println(ast.getIdent() + " = ");
		ast.getExpression().accept(new PrintExpressionVisitor(depth+1));
		return true;
	}

	@Override
	public Boolean visit(Else ast) {
		System.out.print("STAT ELSE ");
		ast.getBlock().accept(new PrintExpressionVisitor(depth+1));
		return true;
	}

	@Override
	public Boolean visit(Form ast) {
		System.out.print("STAT FORM ");
		System.out.println(ast.getIdent() + " : ");
		ast.getContent().accept(new PrintExpressionVisitor(depth+1));
		return true;
	}

	@Override
	public Boolean visit(If ast) {
		System.out.println("STAT IF ");
		ast.getCondition().accept(new PrintExpressionVisitor(depth+1));
		return true;
	}

	@Override
	public Boolean visit(Question ast) {
		System.out.print("STAT QUESTION '");
		System.out.println(ast.getQuestion() + "' : ");
		ast.getVar().accept(new PrintExpressionVisitor(depth+1));
		return true;
	}

	@Override
	public Boolean visit(Var ast) {
		System.out.print("STAT VAR ");
		System.out.println(ast.getIdent() + " : " + ast.getType());
		return true;
	}

	@Override
	public Boolean visit(ast.type.Bool ast) {
		System.out.println("x");
		return true;
	}

	@Override
	public Boolean visit(ast.type.Str ast) {
		System.out.println("x");
		return true;
	}

	@Override
	public Boolean visit(ast.type.Ident ast) {
		System.out.println("x");
		return true;
	}

	@Override
	public Boolean visit(ast.type.Int ast) {
		System.out.println("xxx");
		return true;
	}

	@Override
	public Boolean visit(Message ast) {
		System.out.println("x");
		return true;
	}

	@Override
	public Boolean visit(ast.type.Money ast) {
		System.out.println("x");
		return true;
	}

	@Override
	public Boolean visit(Numeric ast) {
		System.out.println("x");
		return true;
	}

	@Override
	public Boolean visit(Block ast) {
		System.out.println("Block");
		for(Iterator<Statement> i = ast.iterator(); i.hasNext();)
			i.next().accept(new PrintExpressionVisitor(depth+1));
		return null;
	}

}
