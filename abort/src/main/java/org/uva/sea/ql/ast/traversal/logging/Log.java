package org.uva.sea.ql.ast.traversal.logging;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.base.SyntaxPosition;

/**
 * Represents a log.
 * 
 * @author J. Dijkstra
 */
abstract class Log {
	/**
	 * Array to store the lines in, to easily present it in a later stage.
	 */
	private final List<TypeMessage> log = new ArrayList<TypeMessage>();

	/**
	 * Time format to use when displaying the log.
	 */
	private static final String TIME_FORMAT = "HH:mm:ss";
	/**
	 * Date format used when displaying the log.
	 */
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			TIME_FORMAT);

	/**
	 * Constructor that limits the scope to the this package.
	 */
	protected Log() {
	}

	/**
	 * Add a log line.
	 * 
	 * @param line
	 *            line to add
	 */
	public void add(final TypeMessage line) {
		log.add(line);
	}

	/**
	 * Retrieve the length (in lines) of the log.
	 * 
	 * @return amount of lines of the log
	 */
	public int getLength() {
		return log.size();
	}

	@Override
	public String toString() {
		if (log.size() == 0) {
			return "";
		}

		final StringBuffer buffer = new StringBuffer();

		for (final TypeMessage line : log) {
			buffer.append(getStringRepresentation(line));
		}

		return buffer.toString();
	}

	/**
	 * Write the log to a stream.
	 * 
	 * @param stream
	 *            stream to write the log to
	 */
	public void write(final PrintStream stream) {
		for (final TypeMessage line : log) {
			stream.print(getStringRepresentation(line));
		}
	}

	/**
	 * Retrieve the string representation of a line in the log.
	 * 
	 * @param line
	 *            line to retrieve the string representation of
	 * @return string representation of the line
	 */
	private String getStringRepresentation(final TypeMessage line) {
		final String nodeName = line.getNode().toString();
		final String timestamp = dateFormat.format(line.getCalendar().getTime());
		final SyntaxPosition syntaxPosition = line.getNodeSyntaxPosition();
		
		return String.format("[%s]: %s -> %s (line: %d, column: %s)\n",
				timestamp,
				nodeName,
				line.getText(),
				syntaxPosition.getLineNumber(),
				syntaxPosition.getColumnNumber());
	}
}
