package org.uva.sea.ql.ui.control;

abstract public class PanelControl extends Control {
	private String name;

	public void setName( String name ) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	abstract public void add( Control control );
}
