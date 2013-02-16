package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserTypes;

public class TypeParserChecker extends ASTNodeChecker {
	
	public TypeParserChecker() {
		super(new ANTLRParserTypes());
	}
	
	public void inputMatchesTypeBoolean(String input) throws ParseError { assertEquals(getAstNodeFor(input), Bool.class);  }
	public void inputMatchesTypeInteger(String input) throws ParseError { assertEquals(getAstNodeFor(input), Int.class);   }
	public void inputMatchesTypeMoney(String input)   throws ParseError { assertEquals(getAstNodeFor(input), Money.class); }
	public void inputMatchesTypeString(String input)  throws ParseError { assertEquals(getAstNodeFor(input), Str.class);   }
	
}