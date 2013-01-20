package org.uva.sea.ql.ast.traversal.logging;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

abstract class Log {
	// Store the log in an array list to easily present it in a later stage
	protected final List<Line> log = new ArrayList<Line>();

	// Used for date formatting the log
	private static final String TIME_FORMAT = "HH:mm:ss";
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
	
	// Only usable in extended form
	protected Log() { }
	
	public void add(final Line line) {
		log.add(line);
	}
	
	public int getLength() {
		return log.size();
	}
	
	@Override
	public String toString() {
		if (log.size() == 0) {
			return "";
		}

		final StringBuffer buffer = new StringBuffer();
		
		for (final Line line : log) {
			buffer.append(getStringRepresentation(line));
		}
		
		return buffer.toString();
	}
	
	// Write the log to a stream
	public void write(final PrintStream stream) {
		for (final Line line : log) {
			stream.print(getStringRepresentation(line));
		}
	}
	
	// Get the string representation of a line instance
	private String getStringRepresentation(final Line line) {
		return String.format("[%s]: %s -> %s\n", dateFormat.format(line.getCalendar().getTime()),
				line.getNode().toString(), line.getText());
	}
}
