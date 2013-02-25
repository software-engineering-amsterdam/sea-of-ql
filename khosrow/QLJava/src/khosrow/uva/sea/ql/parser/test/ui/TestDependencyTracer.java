package khosrow.uva.sea.ql.parser.test.ui;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import khosrow.uva.sea.ql.ast.expr.Expr;
import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;
import khosrow.uva.sea.ql.parser.test.IParse;
import khosrow.uva.sea.ql.parser.test.ParseError;
import khosrow.uva.sea.ql.ui.DependencyTracer;

import org.junit.Before;
import org.junit.Test;

public class TestDependencyTracer {
	private IParse parser;
	private List<Ident> dependencies;

	@Before
	public void setUp() {
		parser = new JACCParser();
		dependencies = new ArrayList<Ident>();
	}

	@Test
	public void testAdds() throws ParseError {
		Expr expr = parser.ParseExpression("A + B + C");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 3);		
	}
	
	@Test
	public void testSubs() throws ParseError {
		Expr expr = parser.ParseExpression("A - B - C");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 3);
	}
	
	@Test
	public void testMuls() throws ParseError {
		Expr expr = parser.ParseExpression("A * B * C");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 3);
	}
	
	@Test
	public void testDivs() throws ParseError {
		Expr expr = parser.ParseExpression("A / B / C");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 3);
	}
	
	@Test
	public void testNegs() throws ParseError {
		Expr expr = parser.ParseExpression("-A");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 1);	
	}
	
	@Test
	public void testPos() throws ParseError {
		Expr expr = parser.ParseExpression("+A");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 1);
	}
	
	@Test
	public void testMods() throws ParseError {
		Expr expr = parser.ParseExpression("A % B % C");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 3);
	}
	
	@Test
	public void testEqs() throws ParseError {
		Expr expr = parser.ParseExpression("A == B");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 2);
	}
	
	@Test
	public void testNeqs() throws ParseError {
		Expr expr = parser.ParseExpression("A != B");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 2);
	}
	
	@Test
	public void testGeqs() throws ParseError {			
		Expr expr = parser.ParseExpression("A >= B");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 2);
	}
	
	@Test
	public void testGTs() throws ParseError {			
		Expr expr = parser.ParseExpression("A > B");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 2);				
	}
	
	@Test
	public void testLeqs() throws ParseError {			
		Expr expr = parser.ParseExpression("A <= B");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 2);				
	}
	
	@Test
	public void testLTs() throws ParseError {			
		Expr expr = parser.ParseExpression("A < B");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 2);
	}
	
	@Test
	public void testNots() throws ParseError {			
		Expr expr = parser.ParseExpression("!A");
		DependencyTracer.getDependencies(expr, dependencies);
		assertTrue(dependencies.size() == 1);
	}

}
