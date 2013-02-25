package org.uva.sea.ql.parser;

import org.uva.sea.ql.ICodeLocationInformation;

/**
 * Parse error with line, column and source file information attached.
 */
public class QLError {

	private final int lineNumber;
	private final int column;
	private final String sourceFile;
	private final String message;
	private static final String messageFormat = "Parse error: \"%s\" near line %d, column %d in \"%s\"";

	/**
	 * Create a new ParseError using an IErrorInformation implementation to
	 * retrieve file, line and column information. The information is retrieved
	 * from the IErrorInformation directly and persisted in the ParseError
	 * object.
	 */
	public QLError(final ICodeLocationInformation info, final String message) {
		this(info.getLineNumber(), info.getColumn(), info.getFileName(),
				message);
	}

	/**
	 * Create a new ParseError object.
	 * 
	 * @param lineNumber
	 *            Line number where the error occurred.
	 * @param column
	 *            Column number where the error occurred.
	 * @param sourceFile
	 *            Source file where the error occurred.
	 * @param message
	 *            Specify error details.
	 */
	QLError(final int lineNumber, final int column, final String sourceFile,
			final String message) {
		this.lineNumber = lineNumber;
		this.column = column;
		this.sourceFile = sourceFile;
		this.message = String.format(messageFormat, message, lineNumber,
				column, sourceFile);
	}

	/**
	 * @return Character position in the line of the source file.
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * @return Line number in the source file.
	 */
	public int getLineNumber() {
		return this.lineNumber;
	}

	public String getMessage() {
		return this.message;
	}

	/**
	 * @return Source file of the error origin.
	 */
	public String getSourceFile() {
		return this.sourceFile;
	}

}