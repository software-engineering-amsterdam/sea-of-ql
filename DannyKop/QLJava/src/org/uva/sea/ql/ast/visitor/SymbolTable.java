package org.uva.sea.ql.ast.visitor;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.NullType;

/**
 * Class: SymbolTable
 * @author Danny
 * 
 */
public class SymbolTable  {

	Map<String, Expr> table = new HashMap<String, Expr>();

	/**
	 * hasIdentifier
	 * @param id 
	 * @return bool - true if id exists in the symbol table, false otherwise
	 */
	public boolean hasIdentifier(Ident id){
		return this.table.containsKey(id.getName());
	}
	
	/**
	 * getTypeForIdentifier
	 * Checks the symbol table
	 * @param i
	 * @return type of identifier
	 */
	public Expr getTypeForIdentifier(Ident i){
		if(!hasIdentifier(i)){
			return new NullType();
		}
		return this.table.get(i.getName());
	}
	
	/**
	 * addToTable
	 * @param id
	 * @param t
	 * @return boolean - true on inserting, false otherwise
	 */
	public boolean addToTable(Ident id, Expr t){
		if(!this.table.containsKey(id.getName())){
			this.table.put(id.getName(), t);
			return true;
		}
		return false;
	}

}
