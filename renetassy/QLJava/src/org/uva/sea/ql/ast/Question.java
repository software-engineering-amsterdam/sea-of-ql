package org.uva.sea.ql.ast;

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
