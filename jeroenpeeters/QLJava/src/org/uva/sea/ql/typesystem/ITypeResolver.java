package org.uva.sea.ql.typesystem;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.binary.Add;
import org.uva.sea.ql.ast.expression.binary.And;
import org.uva.sea.ql.ast.expression.binary.Div;
import org.uva.sea.ql.ast.expression.binary.Eq;
import org.uva.sea.ql.ast.expression.binary.GEq;
import org.uva.sea.ql.ast.expression.binary.LEq;
import org.uva.sea.ql.ast.expression.binary.LT;
import org.uva.sea.ql.ast.expression.binary.Mul;
import org.uva.sea.ql.ast.expression.binary.NEq;
import org.uva.sea.ql.ast.expression.binary.Or;
import org.uva.sea.ql.ast.expression.binary.Sub;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;

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
