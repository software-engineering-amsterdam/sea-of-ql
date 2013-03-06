package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;
import org.uva.sea.ql.typesystem.QLTypeSystem;
import org.uva.sea.ql.visitor.semantics.TypeCheckError;
import org.uva.sea.ql.visitor.semantics.TypeCheckVisitor;

public class TestTypeChecking {

	private IParse parser;
	
	private QLTypeSystem typeSystem;
	
	@Before
	public void setup() {
		parser = new JaccQLParser();
		typeSystem = new QLTypeSystem();
		
		typeSystem.register(new Identifier("textIdent"), DataType.TEXT);
		typeSystem.register(new Identifier("boolIdent"), DataType.BOOLEAN);
		typeSystem.register(new Identifier("integerIdent"), DataType.INTEGER);
		typeSystem.register(new Identifier("moneyIdent"), DataType.MONEY);
		typeSystem.register(new Identifier("undefIdent"), DataType.UNDEF);
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

		TypeCheckVisitor visitor = new TypeCheckVisitor(typeSystem);
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
