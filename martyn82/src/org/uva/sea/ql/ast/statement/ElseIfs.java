package org.uva.sea.ql.ast.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a list of ElseIfs.
 */
public class ElseIfs implements Node, Iterable<ElseIf> {
	/**
	 * Holds the elseifs this collection represents.
	 */
	private final List<ElseIf> elseIfs;

	/**
	 * Constructs a new ElseIf list.
	 *
	 * @param elseIf
	 * @param elseIfs
	 */
	public ElseIfs( ElseIf elseIf, ElseIfs elseIfs ) {
		this();
		this.elseIfs.add( elseIf );
		this.elseIfs.addAll( elseIfs.elseIfs );
	}

	/**
	 * Constructs a new ElseIf list.
	 *
	 * @param elseIf
	 */
	public ElseIfs( ElseIf elseIf ) {
		this();
		this.elseIfs.add( elseIf );
	}

	/**
	 * Constructs a new ElseIf list.
	 */
	public ElseIfs() {
		this.elseIfs = new LinkedList<ElseIf>();
	}

	/**
	 * Retrieves the number of ELSE-IF elements in this collection.
	 *
	 * @return The count.
	 */
	public int size() {
		return this.elseIfs.size();
	}

	@Override
	public Iterator<ElseIf> iterator() {
		return this.elseIfs.iterator();
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
