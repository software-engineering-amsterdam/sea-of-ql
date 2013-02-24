package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.misc.Location;

public abstract class AbstractIfThenElse extends FormElement {
	private final Body body;
	private final Location startLocation;
	
	public AbstractIfThenElse(Body body, Location startLocation) {
		this.body = body;
		this.startLocation = startLocation;
	}
	
	public Body getBody() {
		return body;
	}
	
	public Location getLocation() {
		return new Location(startLocation, body.getLocation());
	}
	
}
