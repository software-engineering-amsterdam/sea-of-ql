package eu.karuza.ql.interpret;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import eu.karuza.ql.ast.IfConditionalStatement;
import eu.karuza.ql.ast.Form;
import eu.karuza.ql.ast.expr.grouping.Expr;
import eu.karuza.ql.ast.expr.value.Value;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.parser.antlr.ANTLRParser;
import eu.karuza.ql.semantic.StatementSemanticChecker;

public class TestEvaluate {
	
	@Test
	public void testIdents() throws ParseError {
		assertEquals(true, getValueFrom3rdExpression("form form1 { question1 : \"label1\" true question2 : \"label2\" false if(question1 || question2) { question3: \"label3\" \"string\"  } }").getRawValue());
		assertEquals(false, getValueFrom3rdExpression("form form1 { question1 : \"label1\" true question2 : \"label2\" false if(question1 && question2) { question3: \"label3\" \"string\"  } }").getRawValue());
	}
	
	@Test
	public void testBooleans() throws ParseError {
		assertEquals(true, getValueFromSimpleExpression("true").getRawValue());
		assertEquals(false, getValueFromSimpleExpression("false").getRawValue());
		assertEquals(true, getValueFromSimpleExpression("true && true").getRawValue());
		assertEquals(false, getValueFromSimpleExpression("true && false").getRawValue());
		assertEquals(true, getValueFromSimpleExpression("true || false").getRawValue());
		assertEquals(false, getValueFromSimpleExpression("false || false").getRawValue());
		assertEquals(true, getValueFromSimpleExpression("!false").getRawValue());
		assertEquals(true, getValueFromSimpleExpression("1 == 1").getRawValue());
	}

	@Test
	public void testInt() throws ParseError {
		assertEquals(Integer.valueOf(2), getValueFromExpression("form form1 { if(1+1) { question1: \"Some label\" boolean } }").getRawValue());
		assertEquals(Integer.valueOf(3), getValueFromExpression("form form1 { if(12 / 4) { question1: \"Some label\" boolean } }").getRawValue());
		assertEquals(Integer.valueOf(1200), getValueFromExpression("form form1 { if(100*12) { question1: \"Some label\" boolean } }").getRawValue());
		assertEquals(Integer.valueOf(1), getValueFromExpression("form form1 { if(+1) { question1: \"Some label\" boolean } }").getRawValue());
		assertEquals(Integer.valueOf(2), getValueFromExpression("form form1 { if(3-1) { question1: \"Some label\" boolean } }").getRawValue());
	}
	
	@Test
	public void testMoney() throws ParseError {
		assertEquals(BigDecimal.valueOf(1.1), getValueFromSimpleExpression("1.1").getRawValue());
		assertEquals(BigDecimal.valueOf(3.5), getValueFromSimpleExpression("1.1 + 2.4").getRawValue());
		assertEquals(BigDecimal.valueOf(12.24), getValueFromSimpleExpression("5.1 * 2.4").getRawValue());
		assertEquals(BigDecimal.valueOf(2.4), getValueFromSimpleExpression("4.8 / 2").getRawValue());
	}
	
	private Value getValueFrom3rdExpression(String src) throws ParseError {
		Form form = parseExpression(src);
		ParserContext context = new ParserContext();
		form.accept(new StatementSemanticChecker(context));
		IfConditionalStatement statement = (IfConditionalStatement) form.getStatements().get(2);
		return statement.getExpr().evaluate();
	}

	private Value getValueFromExpression(String src) throws ParseError {
		Form form = parseExpression(src);
		IfConditionalStatement statement = (IfConditionalStatement) form.getStatements().get(0);
		Value value = statement.getExpr().evaluate();
		return value;
	}

	private Value getValueFromSimpleExpression(String src) throws ParseError {
		IParse parser = new ANTLRParser();
		Expr expression = (Expr) parser.parseExpression(src);
		return expression.evaluate();
	}

	private Form parseExpression(String src) throws ParseError {
		IParse parser = new ANTLRParser();
		return (Form) parser.parseNode(src);
	}

}
