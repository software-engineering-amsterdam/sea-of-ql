package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.LiteralExpr;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.check.expressions.TypeChecker;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.SupportedTypes;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserTypes;

public class ExpressionTypeChecker {
	
	private final IParser _parser;
	private final SupportedTypes _supportedTypes;
	
	public ExpressionTypeChecker() {
		_parser = new ANTLRParserExpressions();
		_supportedTypes = new SupportedTypes();
		
		_supportedTypes.add("boolean", new Bool());
		_supportedTypes.add("integer", new Int());
		_supportedTypes.add("money",   new Money());
		_supportedTypes.add("numeric", new Numeric());
		_supportedTypes.add("string",  new Str());
	}
	
	public void isAValidExpression(String input) throws ParseError {
		assertTrue(checkExpression(parseExpression(input)));
	}
	
	public void isNotAValidExpression(String input) throws ParseError {
		assertFalse(checkExpression(parseExpression(input)));
	}
	
	public void isOfTypeBoolean(String input) throws ParseError { assertTrue(getTypeFor(input).isCompatibleToBool());    }
	public void isOfTypeInt(String input)     throws ParseError { assertTrue(getTypeFor(input).isCompatibleToInt());     }
	public void isOfTypeMoney(String input)   throws ParseError { assertTrue(getTypeFor(input).isCompatibleToMoney());   }
	public void isOfTypeNumeric(String input) throws ParseError { assertTrue(getTypeFor(input).isCompatibleToNumeric()); }
	public void isOfTypeString(String input)  throws ParseError { assertTrue(getTypeFor(input).isCompatibleToStr());     }
	public void isOfTypeIdent(String input)   throws ParseError { assertTrue(isIdentCompatibleWithType(input));          }
	
	private Type getTypeFor(String input) throws ParseError {
		return getTypeForLiteralExpression(input);
	}
	
	private Boolean checkExpression(Expr expr) {
		return TypeChecker.check(expr, _supportedTypes, new ErrorMessages());
	}
	
	private Expr parseExpression(String input) throws ParseError {
		return (Expr) _parser.parse(input);
	}
	
	private LiteralExpr parseLiteralExpression(String input) throws ParseError {
		return (LiteralExpr) parseExpression(input);
	}
	
	private Type parseIdentifier(String input) throws ParseError {
		ANTLRParserTypes parser = new ANTLRParserTypes();
		return parser.parse(input);
	}
	
	private Type getTypeForLiteralExpression(String input) throws ParseError {
		return parseLiteralExpression(input).typeOf(_supportedTypes);
	}
	
	private Type getTypeForIdentifier(String input) throws ParseError {
		return parseIdentifier(input);
	}
	
	private Boolean isIdentCompatibleWithType(String input) throws ParseError {
		Type type = getTypeForIdentifier(input);
		return type.isCompatibleTo(type);
	}
	
}