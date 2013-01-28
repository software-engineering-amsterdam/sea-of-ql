package org.uva.sea.ql.type.checker;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.nodes.IBinaryNode;
import org.uva.sea.ql.ast.nodes.IMultiNode;
import org.uva.sea.ql.ast.nodes.IUnaryNode;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.Condition;
import org.uva.sea.ql.ast.statements.ConditionalStatement;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.type.ITypeCheck;
import org.uva.sea.ql.type.TypeCheckError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class QLTypeChecker implements ITypeCheck{
	
	private List<Condition> conditions = new ArrayList<Condition>();
	private List<Block> blocks = new ArrayList<Block>();
	private HashMap<Ident, Form> forms	= new HashMap<Ident, Form>();
	
	private List<String> errors = new ArrayList<String>();
	private int errorIndicator = 0;
	
	
	@Override
	public Expr check(Expr x) throws TypeCheckError {
		errorIndicator = 0;
		Expr retVal = this.validateQlTree(x);
		if(errorIndicator != 0){
			String message = "";
			for(int i = 0; i<errorIndicator;i++){
				message += errors.get(i) + "\n";
			}
			throw new TypeCheckError(message);
		}
		
		System.out.println("AST Statistics");
		System.out.println("Counter Blocks : " + blocks.size());
		System.out.println("Counter Forms : " + forms.size());
		System.out.println("Counter Conditions : " + conditions.size());
		validateConditions();
		
		return retVal;
	}
	
	private Expr validateQlTree(Expr x){
		Expr retVal = x;
		validateQlFormExpression(x);
		return retVal;
	}
	
	private Expr validateQlFormExpression(Expr x){
		Expr retVal = x;
		if(x.getClass() == Form.class){
			Form form = (Form)x;
			Ident formIdent = (Ident)form.getLhs();
			forms.put(formIdent,form);
			checkExpressionNode(x);
		} else {
			incrementErrorIndicator();
			errors.add("No Form Node Tree Entry Point Found Exmpl. { form Ident {Block Node} }!");
		}
		return retVal;
	}
	
	private void incrementErrorIndicator(){
		errorIndicator++;
	}
	
	public int getErrorIndicator(){
		return errorIndicator;
	}
	
	private Expr checkExpressionNode(Expr x){
		Expr retVal = x;
		if(x.isBinaryNode()) { checkBinaryNode(x); }
		if(x.isMultiNode())  { checkMultiNode(x);  }
		if(x.isUnaryNode())  { checkUnaryNode(x);  }
		return retVal;
	}
	
	private Expr checkBinaryNode(Expr x){
		Expr retVal = x;
		IBinaryNode ib = (IBinaryNode)x;
		validateBinaryNode(x);
		checkExpressionNode(ib.getLhs());
		checkExpressionNode(ib.getRhs());
		return retVal;
	}
	
	private Expr checkUnaryNode(Expr x){
		Expr retVal = x;
		IUnaryNode value = (IUnaryNode)x;
		if(value.hasExpr()){
			checkExpressionNode(value.getExpr());
		} else {
			System.out.println("VAL Value Found : " + value.getValue());
		}
		return retVal;
	}
	
	private Expr checkMultiNode(Expr x){
		Expr retVal = x;
		IMultiNode block = (IMultiNode)x;
		System.out.println("VAL Block Found : " + block.getValuesCount());
		for(int i = 0; i < block.getValuesCount(); i++){
			checkExpressionNode(block.getValue(i));
		}
		return retVal;
	}
	
	
	
	
	
	private void validateBinaryNode(Expr x){
		addBinaryNodeActualExpression(x);
	}
	
	private void addBinaryNodeActualExpression(Expr x){
		if(x.getClass() == Form.class){
			System.out.println("VAL Form Found ");
			IBinaryNode bn = (IBinaryNode)x;
			Block block = (Block)bn.getRhs();
			blocks.add(block);
			System.out.println("VAL Form Added ");
		}
		if(x.getClass() == ConditionalStatement.class){
			System.out.println("VAL ConditionalStatement Found ");
			IBinaryNode conSt = (IBinaryNode)x;
			conditions.add((Condition)conSt.getLhs());
			blocks.add((Block)conSt.getRhs());
			System.out.println("VAL Condition and Block Added ");
		}
	}
	
	private void validateConditions(){
		for(int i = 0;i<conditions.size();i++){
			validateConditionStatement(conditions.get(i));
		}
	}
	
	private void validateConditionStatement(Expr con){
		if(con.isUnaryNode()){
			IUnaryNode un = (IUnaryNode)con;
			if(un.hasExpr()){
				Expr x = un.getExpr();
				if(x.isUnaryNode()){
					IUnaryNode altUn = (IUnaryNode)x;
					if(altUn.hasExpr()){
						validateConditionStatement(x);
					} else {
						if(x.getClass() == Ident.class){
							incrementErrorIndicator();
							errors.add("Condition needs to be a Ident");
						}
					}
				}
				if(x.isBinaryNode()){
					// validate Binary
					
					
					
					
				}
			} else {
				if(con.getClass() == Ident.class){
					incrementErrorIndicator();
					errors.add("Condition needs to be a Ident");
				}
			}
		}
	}
}



