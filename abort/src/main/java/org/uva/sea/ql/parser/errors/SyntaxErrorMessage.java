package org.uva.sea.ql.parser.errors;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.uva.sea.ql.ast.base.SyntaxPosition;

/**
 * Syntax Error Message that could be constructed by failure in syntax parsing.
 * 
 * @author J. Dijkstra
 */
public class SyntaxErrorMessage {
	/**
	 * Time format to use when displaying the log.
	 */
	private static final String TIME_FORMAT = "HH:mm:ss";
	/**
	 * Date format used when displaying the log.
	 */
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);

	/**
	 * Syntax position where the error occurred.
	 */
	private final SyntaxPosition syntaxPosition;

	/**
	 * Message provided by ANTLR.
	 */
	private final String originalMessage;
	/**
	 * Current calendar to use for printing a timestamp.
	 */
	private final Calendar calendar = Calendar.getInstance();

	/**
	 * Constructor.
	 * 
	 * @param syntaxPosition
	 *            syntax position
	 * @param originalMessage
	 *            original message
	 */
	public SyntaxErrorMessage(final SyntaxPosition syntaxPosition, final String originalMessage) {
		this.syntaxPosition = syntaxPosition;
		this.originalMessage = originalMessage;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s (line: %d, column: %d)", dateFormat.format(calendar.getTime()), originalMessage,
				syntaxPosition.getLineNumber(), syntaxPosition.getColumnNumber());
	}
}
