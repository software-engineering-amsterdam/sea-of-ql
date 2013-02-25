package org.uva.sea.ql.ast;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * Most abstract form of a node in an abstract syntax tree. Provides information
 * about the location of the node in the physical source file using
 * ICodeLocationInformation.
 */
public abstract class Node implements ICodeLocationInformation {

	private final ICodeLocationInformation info;

	public Node(ICodeLocationInformation info) {
		this.info = info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.uva.sea.ql.ICodeLocationInformation#getLineNumber()
	 */
	public final int getLineNumber() {
		return info.getLineNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.uva.sea.ql.ICodeLocationInformation#getColumn()
	 */
	@Override
	public final int getColumn() {
		return info.getColumn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.uva.sea.ql.ICodeLocationInformation#getFileName()
	 */
	@Override
	public final String getFileName() {
		return info.getFileName();
	}

}
