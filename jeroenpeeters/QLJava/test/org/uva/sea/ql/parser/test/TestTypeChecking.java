package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.TextType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefType;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;
import org.uva.sea.ql.visitor.TypeCheckError;
import org.uva.sea.ql.visitor.TypeCheckVisitor;

import com.google.common.collect.Maps;

public class TestTypeChecking {

	private IParse parser;
	
	private Map<Identifier, Type> typeEnv;
	
	@Before
	public void setup() {
		parser = new JaccQLParser();
		typeEnv = Maps.newHashMap();
		
		typeEnv.put(new Identifier("textIdent"), new TextType());
		typeEnv.put(new Identifier("boolIdent"), new BooleanType());
		typeEnv.put(new Identifier("integerIdent"), new IntegerType());
		typeEnv.put(new Identifier("moneyIdent"), new MoneyType());
		typeEnv.put(new Identifier("undefIdent"), new UndefType());
	}
	
	@Test
	public void testAdd() throws ParseError{
		testExpression("1 + true");
		testExpression("1 + boolIdent");
		testExpression("1 + undefIdent");
		testExpression("undefIdent + 2");
	}
	
	@Test
	public void testNot() throws ParseError{
		testExpression("!2");
		testExpression("!textIdent");
		testExpression("!integerIdent");
		testExpression("!moneyIdent");
		testExpression("!undefIdent");
		testExpression("!(1+2)");
	}
	
	@Test
	public void testEq() throws ParseError{
		testExpression("1 == undefIdent");
	}
	
	private void testExpression(final String qlText) throws ParseError{
		Expression expr = parser.parseExpression(qlText);
		assertNotNull(expr);

		TypeCheckVisitor visitor = new TypeCheckVisitor(typeEnv);
		expr.accept(visitor);
		
		System.out.println("===== >" + qlText);
		
		int i = 0;
		Iterator<TypeCheckError> iterator = visitor.getTypeCheckErrorIterator();
		while(iterator.hasNext()){
			TypeCheckError error = iterator.next();
			System.out.println(error);
			i++;
		}
		
		assertEquals("qlText: '"+qlText+"'", 1, i);
		
	}
	
}
