package org.uva.sea.ql.ast.traversal.typechecking.base;

import java.util.Set;

import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.DataType;

public interface ISymbolTable {
	DataType getDataTypeByName(String identName);
	boolean containsIdentName(String identName);
	boolean isInputIncomplete(Set<String> identNames);
	
	void add(Ident ident, DataType dataType);
	DataType get(Ident ident);
}
