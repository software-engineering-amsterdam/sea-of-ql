package khosrow.uva.sea.ql.ast.stmt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import khosrow.uva.sea.ql.visitor.IStmtVisitor;

public class Stmts extends Stmt implements Iterable<Stmt> {
	private final List<Stmt> stmts;

	public Stmts(Stmts stmts, Stmt stmt) {
		this(stmt);
		this.stmts.addAll(stmts.stmts);
	}

	public Stmts(Stmt stmt) {
		this();
		this.stmts.add(stmt);
	}
	public Stmts() {
		stmts = new LinkedList<Stmt>();
	}

	@Override
	public Iterator<Stmt> iterator() {
		return stmts.iterator();
	}

	@Override
	public <T> T accept(IStmtVisitor<T> visitor) {		
		return visitor.visit(this);
	}	
}
