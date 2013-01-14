package org.uva.sea.ql.ast;

import org.uva.sea.ql.ICodeLocationInformation;


public abstract class Node implements ICodeLocationInformation {

	private final ICodeLocationInformation info;

	public Node(ICodeLocationInformation info)
	{
		this.info = info;
	}
	/* (non-Javadoc)
	 * @see org.uva.sea.ql.IErrorInformation#getLineNumber()
	 */
	public final int getLineNumber() {
		return info.getLineNumber();
	}

	/* (non-Javadoc)
	 * @see org.uva.sea.ql.IErrorInformation#getColumn()
	 */
	@Override
	public final int getColumn() {
		return info.getColumn();
	}

	/* (non-Javadoc)
	 * @see org.uva.sea.ql.IErrorInformation#getFileName()
	 */
	@Override
	public final String getFileName() {
		return info.getFileName();
	}

}
