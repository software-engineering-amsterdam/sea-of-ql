package khosrow.uva.sea.ql.ui;

import java.util.List;

import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class DependencyTracer implements IExprVisitor<Void>{
	private final List<Ident> dependencies;
	
	private DependencyTracer(List<Ident> dependencies){
		this.dependencies = dependencies;
	}
	
	public static Void getDependencies(Expr expr, List<Ident> dependencies) {
		DependencyTracer tracer = new DependencyTracer(dependencies);
		expr.accept(tracer);
		return null;
	}	
	
	@Override
	public Void visit(Add ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(And ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Div ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Eq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(GEq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(GT ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Ident ast) {
		this.dependencies.add(ast);
		return null;
	}

	@Override
	public Void visit(LEq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(LT ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Mod ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Mul ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Neg ast) {
		ast.getArg().accept(this);
		return null;
	}

	@Override
	public Void visit(NEq ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Not ast) {
		ast.getArg().accept(this);
		return null;
	}

	@Override
	public Void visit(Or ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(Pos ast) {
		ast.getArg().accept(this);
		return null;
	}

	@Override
	public Void visit(Sub ast) {
		ast.getLhs().accept(this);
		ast.getRhs().accept(this);
		return null;
	}

	@Override
	public Void visit(IntLiteral ast) {		
		return null;
	}

	@Override
	public Void visit(BoolLiteral ast) {		
		return null;
	}

	@Override
	public Void visit(MoneyLiteral ast) {		
		return null;
	}

	@Override
	public Void visit(StringLiteral ast) {		
		return null;
	}

}
