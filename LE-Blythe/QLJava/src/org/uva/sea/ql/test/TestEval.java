package org.uva.sea.ql.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operative.Add;
import org.uva.sea.ql.ast.operative.And;
import org.uva.sea.ql.ast.operative.Div;
import org.uva.sea.ql.ast.operative.Eq;
import org.uva.sea.ql.ast.operative.GEq;
import org.uva.sea.ql.ast.operative.GT;
import org.uva.sea.ql.ast.operative.LEq;
import org.uva.sea.ql.ast.operative.LT;
import org.uva.sea.ql.ast.operative.Mul;
import org.uva.sea.ql.ast.operative.NEq;
import org.uva.sea.ql.ast.operative.Not;
import org.uva.sea.ql.ast.operative.Or;
import org.uva.sea.ql.ast.operative.Sub;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.interpreter.VisitorEvalExpr;
import org.uva.sea.ql.util.Environment;

public class TestEval {

	private Primitive eval(Expr ex){
		return ex.accept(new VisitorEvalExpr(new Environment()));
	}
	
	
	private int evalInt(Expr ex){
		return ((Int)eval(ex)).getValue();
	}
	
	
	private boolean evalBool(Expr ex){
		return ((Bool)eval(ex)).getValue();
	}
	
	@Test
	public void numericOperations(){
		Int a = new Int(4);
		Int b = new Int(2);
		Int bEq = new Int(2);
		
		//mathematical
		assertTrue( evalInt(new Add(a, b)) == 6 );
		assertTrue( evalInt(new Sub(a, b)) == 2 );
		assertTrue( evalInt(new Div(a, b)) == 2 );
		assertTrue( evalInt(new Mul(a, b)) == 8 );
		
		//comparative
		
		// ==
		assertTrue( evalBool(new Eq(a,b)) == false );
		assertTrue( evalBool(new Eq(b,bEq)) == true );
		
		// !=
		assertTrue( evalBool(new NEq(a,b)) == true);
		assertTrue( evalBool(new NEq(b,bEq)) == false);
		
		// >=
		assertTrue( evalBool(new GEq(a,b)) == true );
		assertTrue( evalBool(new GEq(b,bEq)) == true );
		assertTrue( evalBool(new GEq(b,a)) == false );
		
		// >
		assertTrue( evalBool(new GT(a,b)) == true );
		assertTrue( evalBool(new GT(b,bEq)) == false );
		assertTrue( evalBool(new GT(b,a)) == false );
		
		// <= 
		assertTrue( evalBool(new LEq(a,b)) == false );
		assertTrue( evalBool(new LEq(b,bEq)) == true );
		assertTrue( evalBool(new LEq(b,a)) == true );
		
		// < 
		assertTrue( evalBool(new LT(a,b)) == false );
		assertTrue( evalBool(new LT(b,bEq)) == false );
		assertTrue( evalBool(new LT(b,a)) == true );
		
		// pos
		
		
		// neg
	}
	
	
	@Test
	public void booleanOperations(){
		Bool t1 = new Bool(true);
		Bool t2 = new Bool(true);
		
		Bool f1 = new Bool(false);
		Bool f2 = new Bool(false);
		
		// &&
		assertTrue( evalBool(new And(t1, t2)) == true );
		assertTrue( evalBool(new And(t1, f1)) == false );
		assertTrue( evalBool(new And(f1, f2)) == false );
		
		// ||
		assertTrue( evalBool(new Or(t1, t2)) == true );
		assertTrue( evalBool(new Or(f1, t1)) == true );
		assertTrue( evalBool(new Or(f1, f2)) == false );
		
		// ==
		assertTrue( evalBool(new Eq(t1, t2)) == true );
		assertTrue( evalBool(new Eq(f1, f2)) == true );
		assertTrue( evalBool(new Eq(f1, t1)) == false );

		// != 
		assertTrue( evalBool(new NEq(t1, t2)) == false );
		assertTrue( evalBool(new NEq(f1, f2)) == false );
		assertTrue( evalBool(new NEq(f1, t1)) == true );		
		
		// !
		assertTrue( evalBool(new Not(t1)) == false );
		assertTrue( evalBool(new Not(f1)) == true );
	}
	
	@Test
	public void stringOperations(){
		Str a = new Str("a");
		Str b = new Str("b");
		Str bEq = new Str("b");

		// ==
		assertTrue( evalBool(new Eq(a,b)) == false );
		assertTrue( evalBool(new Eq(b,bEq)) == true );
				
		// !=
		assertTrue( evalBool(new NEq(a,b)) == true);
		assertTrue( evalBool(new NEq(b,bEq)) == false);

	}
}
