package khosrow.uva.sea.ql.ast.stmt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import khosrow.uva.sea.ql.ast.ASTNode;

public class Stmts extends ASTNode implements Iterable<Stmt> {
	private final List<Stmt> stmts;

	public Stmts(Stmts stmts, Stmt stmt) {
		this();
		this.stmts.addAll(stmts.stmts);
	}

	public Stmts() {
		stmts = new LinkedList<Stmt>();
	}

	@Override
	public Iterator<Stmt> iterator() {
		return stmts.iterator();
	}

}
