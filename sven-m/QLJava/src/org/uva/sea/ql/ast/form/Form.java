package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Location;

public class Form implements ASTNode {
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
	public Location getLocation() {
		return new Location(startLocation, body.getLocation());
	}
	
}
