package org.uva.sea.ql.ast.visitors.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.ExpressionTypeFindingVisitor;

public class ExpressionTypeFindingVisitorTests {

	private ExpressionTypeFindingVisitor target;
	private Map<Identifier, Type> identifierTypeMap;

	Identifier identifier;
	Type type;

	@Before
	public void setUp() {
		identifierTypeMap = new HashMap<Identifier, Type>();
		identifier = new Identifier("hasSoldHouse");
		type = new BooleanType();

		identifierTypeMap.put(identifier, type);
		this.target = new ExpressionTypeFindingVisitor(identifierTypeMap);
	}

	@Test
	public void does_findTypeOfIdentifierFromMap_when_identifierExistsInMap() {

		Type foundType = this.target.visit(identifier);
		assertEquals(type.getClass(), foundType.getClass());
	}

}
