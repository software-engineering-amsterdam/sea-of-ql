package org.uva.sea.ql.ui.control;

abstract public class WindowControl {
	private final PanelControl panel;

	protected WindowControl( PanelControl panel ) {
		this.panel = panel;
	}

	protected PanelControl getPanel() {
		return this.panel;
	}

	abstract public void show();
	abstract public void hide();
}
