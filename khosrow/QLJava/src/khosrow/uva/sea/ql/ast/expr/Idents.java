package khosrow.uva.sea.ql.ast.expr;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Idents extends Expr implements Iterable<Ident> {
	private final List<Ident> idents;

	public Idents(Ident ident, Idents idents) {
		this(ident);
		this.idents.addAll(idents.idents);
	}

	public Idents(Ident ident) {
		idents = new LinkedList<Ident>();
		idents.add(ident);
	}

	@Override
	public Iterator<Ident> iterator() {
		return idents.iterator();
	}

}
