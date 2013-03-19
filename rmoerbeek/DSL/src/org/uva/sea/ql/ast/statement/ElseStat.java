package org.uva.sea.ql.ast.statement;

public class ElseStat {
	
	private final Body elseBody;

	public ElseStat(Body eB) {
		this.elseBody = eB;
	}
	
	public Body getBody() {
		return elseBody;
	}

}
