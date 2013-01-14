package org.uva.sea.ql;


public class CodeLocationInformationImpl implements ICodeLocationInformation {

	private final int lineNumber;
	private final int column;
	private final String fileName;
	
	public CodeLocationInformationImpl(int lineNumber, int column, String fileName)
	{
		this.lineNumber = lineNumber;
		this.column = column;
		this.fileName = fileName;
	}
	
	@Override
	public int getLineNumber() {
		return lineNumber;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

}
