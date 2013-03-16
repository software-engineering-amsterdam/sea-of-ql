package org.uva.sea.ql.typesystem;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.Literal;

/**
 * Resolves the {@link DataType} of an {@link Expression}.
 * 
 * @author jpeeters
 * 
 */
public interface ITypeResolver {

	DataType resolve(Expression expr);
	
//	// Generic expressions
//
//	DataType resolve(Identifier identifier);
//
//	DataType resolve(Literal literal);
//
//	// Binary expressions
//
//	DataType resolve(Add expression);
//
//	DataType resolve(Div expression);
//
//	DataType resolve(Mul expression);
//
//	DataType resolve(Sub expression);
//
//	DataType resolve(And expression);
//
//	DataType resolve(Eq expression);
//
//	DataType resolve(GEq expression);
//
//	DataType resolve(LEq expression);
//
//	DataType resolve(LT expression);
//
//	DataType resolve(NEq expression);
//
//	DataType resolve(Or expression);
//
//	// Unary
//
//	DataType resolve(Neg expression);
//
//	DataType resolve(Pos expression);
//
//	DataType resolve(Not expression);

}
