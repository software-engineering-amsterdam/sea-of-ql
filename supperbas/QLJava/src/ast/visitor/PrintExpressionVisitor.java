package ast.visitor;

import ast.expression.*;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.*;

public class PrintExpressionVisitor implements Visitor<Boolean> {
	
	private int level = 0;

	public PrintExpressionVisitor() {
		super();
		System.out.println("EXPR VISITOR");
	}
	
	public PrintExpressionVisitor(int level){
		super();
		this.level = level;
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
	
	public void binaryVisit(Binary ast){
		this.level++;
		ast.getLhs().accept(new PrintExpressionVisitor(level));
		ast.getRhs().accept(new PrintExpressionVisitor(level));
		this.level--;
	}
	
	public void unaryVisit(Unary ast){
		this.level++;
		ast.getExpression().accept(new PrintExpressionVisitor(level));
		this.level--;
	}
	
	public void valueVisit(Value ast){
		System.out.println(ast.toString());
	}
	
	public void print(){
		for(int i = 0; i < (level-1); i++)
			System.out.print('|');
		System.out.print('-');
	}

}
