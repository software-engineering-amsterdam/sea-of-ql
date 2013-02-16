package org.uva.sea.ql.parser.errors.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Syntax Error Message that could be constructed by failure in syntax parsing.
 * 
 * @author J. Dijkstra
 */
// TODO: refactor with typecheckerror and syntaxposition
public class SyntaxErrorMessage {
	/**
	 * Time format to use when displaying the log.
	 */
	private static final String TIME_FORMAT = "HH:mm:ss";
	/**
	 * Date format used when displaying the log.
	 */
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
	private final int lineNumber;
	private final int columnNumber;
	private final String originalMessage;
	private final Calendar calendar = Calendar.getInstance();

	public SyntaxErrorMessage(final int lineNumber, final int columnNumber, final String originalMessage) {
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
		this.originalMessage = originalMessage;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s (line: %d, column: %d)\n", dateFormat.format(calendar.getTime()),
				originalMessage, lineNumber, columnNumber);
	}
}
