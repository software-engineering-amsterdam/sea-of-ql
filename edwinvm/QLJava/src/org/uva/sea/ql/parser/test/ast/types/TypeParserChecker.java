package org.uva.sea.ql.parser.test.ast.types;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserTypes;
import org.uva.sea.ql.parser.errors.ParseError;
import org.uva.sea.ql.parser.test.ast.ASTNodeChecker;

public class TypeParserChecker extends ASTNodeChecker {
	
	public TypeParserChecker() {
		super(new ANTLRParserTypes());
	}
	
	public void inputMatchesTypeBoolean(String input) throws ParseError { match(input, Bool.class);  }
	public void inputMatchesTypeInteger(String input) throws ParseError { match(input, Int.class);   }
	public void inputMatchesTypeMoney(String input)   throws ParseError { match(input, Money.class); }
	public void inputMatchesTypeString(String input)  throws ParseError { match(input, Str.class);   }
	
}