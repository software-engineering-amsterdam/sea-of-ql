package org.uva.sea.ql.ast.nodevisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.uva.sea.ql.ast.BigLiteral;
import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanLiteral;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.ast.operators.Add;
import org.uva.sea.ql.ast.operators.And;
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
import org.uva.sea.ql.ast.operators.ExpressionResult;
import org.uva.sea.ql.ast.operators.GEq;
import org.uva.sea.ql.ast.operators.GT;
import org.uva.sea.ql.ast.operators.LEq;
import org.uva.sea.ql.ast.operators.LT;
import org.uva.sea.ql.ast.operators.Mul;
import org.uva.sea.ql.ast.operators.NEq;
import org.uva.sea.ql.ast.operators.Neg;
import org.uva.sea.ql.ast.operators.Not;
import org.uva.sea.ql.ast.operators.Or;
import org.uva.sea.ql.ast.operators.Pos;
import org.uva.sea.ql.ast.operators.Sub;
import org.uva.sea.ql.ast.types.TypeDescription;
import org.uva.sea.ql.driver.ConditionalPanel;
import org.uva.sea.ql.driver.Panel;

public class QLFormSymbolsCreator implements Visitor {
	private String formName;
	private HashMap<String, ExpressionResult> symbols = new HashMap<String, ExpressionResult>();
	private ArrayList<Panel> panels = new ArrayList<Panel>();
	private Stack<ArrayList<Panel>> panelStack = new Stack<ArrayList<Panel>>() ;

	public String getFormName() {
		return formName;
	}

	public HashMap<String, ExpressionResult> getSymbols() {
		return symbols;
	}

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		panels = new ArrayList<Panel>() ;
		formName = qlProgram.getProgramName();
		qlProgram.getCompound().accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(CompoundStatement compoundBlock) {
		panelStack.push(panels) ;
		for (Statement statement : compoundBlock.getStatementList())
			statement.accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(LineStatement lineStatement) {
		Panel newPanel ;
		symbols.put(lineStatement.getLineName(),
				lineStatement.getTypeContainer());
		
		newPanel = new Panel(lineStatement) ;
		
		panels.add(newPanel) ;
		return null;
	}

	public ArrayList<Panel> getPanels() {
		return panels;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		Panel newPanel ;
		//newPanel = new ConditionalPanel(conditionalStatement) ;
		
		
		
		
		
		conditionalStatement.getTrueCompound().accept(this);
		if (conditionalStatement.getFalseCompound() != null) {
			conditionalStatement.getFalseCompound().accept(this);
		}
		return null;
	}

	@Override
	public VisitorResult visit(Expr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Ident expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(IntLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(StringLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(BooleanLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Add expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Mul expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Div expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Sub expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(And expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Or expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Eq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(GT expr) {
		return null;
	}

	@Override
	public VisitorResult visit(LT expr) {
		return null;
	}

	@Override
	public VisitorResult visit(LEq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(NEq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(GEq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Not expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Neg expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Pos expr) {
		return null;
	}

	@Override
	public VisitorResult visit(TypeDescription typeDescription) {
		return null;
	}

	@Override
	public VisitorResult visit(BigLiteral expr) {
		return null;
	}
}
