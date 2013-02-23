package org.uva.sea.ql.ast.stat;

import java.util.List;

import org.uva.sea.ql.ast.visitor.VisitorStatements;

public class Block extends FormUnit{
	
	private final List<FormUnit> body;
	
	public Block(List<FormUnit> body) {
			this.body = body;
		}

		public List<FormUnit> getBody() {
			return body;
		}

		@Override
		public <T> T accept(VisitorStatements<T> visitor) {
			return visitor.visit(this);
		}

}
