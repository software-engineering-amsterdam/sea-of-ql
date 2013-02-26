package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.FormNode;
import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Form implements FormNode {
	private final String name;
	private final Body body;
	private final Location startLocation;

	public Form(String name, Body body, Location startLocation) {
		this.name = name;
		this.body = body;
		this.startLocation = startLocation;
	}

	public String getName() {
		return name;
	}

	public Body getBody() {
		return body;
	}

	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Location getLocation() {
		return new Location(startLocation, body.getLocation());
	}

}
