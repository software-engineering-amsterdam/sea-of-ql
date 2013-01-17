package org.uva.sea.ql.ast.traversal.logging;

import java.util.Calendar;

import org.uva.sea.ql.ast.base.Node;

public class Line {
	// Store the time the line was logged
	private final Calendar calendar;
	// The node to log information about	
	private final Node node;
	private final String text;
	
	public Line(final Node node, final String text) {
		calendar = Calendar.getInstance();
		
		this.node = node;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	
	public Node getNode() {
		return node;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}
}
