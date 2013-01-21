package org.uva.sea.ql.ast.traversal.logging;

import java.util.Calendar;

import org.uva.sea.ql.ast.base.Node;

/**
 * Represents a line in a log.
 * @author J. Dijkstra
 */
public class Line {
	/**
	 * Store the time the line was logged.
	 */
	private final Calendar calendar;
	
	/**
	 * The node to log information about.
	 */
	private final Node node;
	
	/**
	 * Store the text the line has to display.
	 */
	private final String text;
	
	/**
	 * Constructor.
	 * @param node node to log about
	 * @param text text to log about the node
	 */
	public Line(final Node node, final String text) {
		calendar = Calendar.getInstance();
		
		this.node = node;
		this.text = text;
	}
	
	/**
	 * Retrieve the text this line stores
	 * @return text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Retrieve the node this line represents
	 * @return node
	 */
	public Node getNode() {
		return node;
	}
	
	/**
	 * Retrieve the calendar that has been initiated with this line.
	 * @return calendar
	 */
	public Calendar getCalendar() {
		return calendar;
	}
}
