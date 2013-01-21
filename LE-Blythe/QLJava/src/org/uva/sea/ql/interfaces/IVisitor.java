package org.uva.sea.ql.interfaces;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.comparative.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.numeric.*;
import org.uva.sea.ql.ast.propositional.*;
import org.uva.sea.ql.util.*;

public interface IVisitor {

	//primitives
	void visit(Ident n, Stack s) throws Exception;
	void visit(Bool n, Stack s) throws Exception;
	void visit(Int n, Stack s)  throws Exception;
	void visit(Str n, Stack s)  throws Exception;
	
	void visit(Form n, Stack s) throws Exception;
	void visit(Body n, Stack s) throws Exception;
	void visit(Question n, Stack s) throws Exception;
	void visit(Branch n, Stack s) throws Exception;
	
	void visit(NumericBaseOperator1 n, Stack s) throws Exception;
	void visit(NumericBaseOperator2 n, Stack s) throws Exception;
	
	void visit(Not n, Stack s) throws Exception;
	void visit(PropositionalBaseOperator2 n, Stack s) throws Exception;
	
	
	void visit(ComparativeBaseOperator2 n, Stack s) throws Exception;
	

}
