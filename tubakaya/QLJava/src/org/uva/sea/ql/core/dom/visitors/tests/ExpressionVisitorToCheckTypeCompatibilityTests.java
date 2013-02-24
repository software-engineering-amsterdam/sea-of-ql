package org.uva.sea.ql.core.dom.visitors.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.operators.arithmetic.Add;
import org.uva.sea.ql.core.dom.operators.conditional.And;
import org.uva.sea.ql.core.dom.operators.relational.Eq;
import org.uva.sea.ql.core.dom.operators.unary.Not;
import org.uva.sea.ql.core.dom.operators.unary.Pos;
import org.uva.sea.ql.core.dom.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.IntDeclaration;
import org.uva.sea.ql.core.dom.types.primitive.IntLiteral;
import org.uva.sea.ql.core.dom.visitors.ExpressionVisitorToCheckTypeCompatibility;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class ExpressionVisitorToCheckTypeCompatibilityTests {

	private ExpressionVisitorToCheckTypeCompatibility target;
	
	@Before
    public void setUp() {
		this.target = new ExpressionVisitorToCheckTypeCompatibility();
    }
	
	@Test
	public void does_addOneError_when_addWithBooleanValueWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new BooleanDeclaration());
		Add add = new Add(identifier, new IntLiteral("2"));
		
		target.visit(add);
		assertEquals(1,target.getExceptions().size());	
	}
	
	@Test
	public void does_addTwoErrors_when_addWithTwoBooleanValuesWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new BooleanDeclaration());
		Identifier identifier2 = new Identifier("identifier2",new BooleanDeclaration());
		Add add = new Add(identifier, identifier2);
		
		target.visit(add);
		assertEquals(2,target.getExceptions().size());	
	}
	
	@Test
	public void does_addTwoErrors_when_andWithTwoIntegerValuesWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new IntDeclaration());
		Identifier identifier2 = new Identifier("identifier2",new IntDeclaration());
		And and = new And(identifier, identifier2);
		
		target.visit(and);
		assertEquals(2,target.getExceptions().size());	
	}
	

	@Test
	public void does_addTwoErrors_when_eqWithOneIntegerAndOneBooleanValuesWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new IntDeclaration());
		Identifier identifier2 = new Identifier("identifier2",new BooleanDeclaration());
		Eq eq = new Eq(identifier, identifier2);
		
		target.visit(eq);
		assertEquals(2,target.getExceptions().size());	
	}
	
	@Test
	public void does_addOneError_when_notWithOneIntegerValueWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new IntDeclaration());
		Not not = new Not(identifier);
		
		target.visit(not);
		assertEquals(1,target.getExceptions().size());	
	}
	
	@Test
	public void does_addOneError_when_posWithOneBooleanValueWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new BooleanDeclaration());
		Pos pos = new Pos(identifier);
		
		target.visit(pos);
		assertEquals(1,target.getExceptions().size());	
	}
	
	
	@Test
	public void does_addNoErrors_when_posWithOneIntegerValueWasVisited() throws ParseException {
		
		Identifier identifier = new Identifier("identifier",new IntDeclaration());
		Pos pos = new Pos(identifier);
		
		target.visit(pos);
		assertEquals(0,target.getExceptions().size());	
	}
}
