package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.qtype.QuestionType;

public class Question extends Statement { 

		private Ident id;
		private StringLiteral label;
		private QuestionType type;
		
		public Question (Ident id, StringLiteral label, QuestionType type) {
			this.id=id;
			this.label=label;
			this.type=type;
			
		}

}
