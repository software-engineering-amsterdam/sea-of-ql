package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.StatementChecker;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class Question extends Statement { 

		private Ident id;
		private StringLiteral label;
		private Type type;
		
		public Question (Ident id, StringLiteral label, Type type) {
			this.id=id;
			this.label=label;
			this.type=type;
		}
		
		public Ident getID() {
			return id;
		}
		
		public StringLiteral getLabel() {
			return label;
		}
		
		public Type getType() {
			return type;
		}

		@Override
		public boolean accept(StatementChecker visitor) {
			return visitor.visit(this);
		}
		
}
