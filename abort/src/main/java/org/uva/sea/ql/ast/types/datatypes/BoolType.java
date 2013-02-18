package org.uva.sea.ql.ast.types.datatypes;

import java.util.regex.*;

/**
 * Represents a boolean data type in the QL language.
 * 
 * @author J. Dijkstra
 */
public class BoolType extends DataType {
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public boolean isAssignableFrom(final String input) {
		final Pattern validBooleanPattern = Pattern.compile("true|false|1|0|on|off", Pattern.CASE_INSENSITIVE);
		final Matcher matcher = validBooleanPattern.matcher(input);
		
		return matcher.matches();
	}
}
