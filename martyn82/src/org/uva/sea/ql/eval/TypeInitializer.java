package org.uva.sea.ql.eval;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.eval.value.Boolean;
import org.uva.sea.ql.eval.value.Integer;
import org.uva.sea.ql.eval.value.Money;
import org.uva.sea.ql.eval.value.String;
import org.uva.sea.ql.eval.value.Value;

/**
 * Static type initializer utility class.
 */
public class TypeInitializer {
	/**
	 * Holds the mapping from datatype to value class.
	 */
	private final static Map<DataType, Class<?>> VALUE_TYPES;

	/**
	 * Initializes the type to value class mapping.
	 */
	static {
		VALUE_TYPES = new HashMap<DataType, Class<?>>();
		VALUE_TYPES.put( DataType.BOOLEAN, org.uva.sea.ql.eval.value.Boolean.class );
		VALUE_TYPES.put( DataType.INTEGER, org.uva.sea.ql.eval.value.Integer.class );
		VALUE_TYPES.put( DataType.MONEY, org.uva.sea.ql.eval.value.Money.class );
		VALUE_TYPES.put( DataType.STRING, org.uva.sea.ql.eval.value.String.class );
	}

	/**
	 * Initializes a value of given type.
	 *
	 * @param type
	 *
	 * @return The initialized value object.
	 *
	 * @throws RuntimeException If given type is unknown.
	 */
	public static Value<?> init( DataType type ) {
		if ( !VALUE_TYPES.containsKey( type ) ) {
			throw new RuntimeException( "Unknown type: " + type.name() );
		}

		Class<?> valueType = VALUE_TYPES.get( type );

		try {
			return (Value<?>) valueType.newInstance();
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Initializes a boolean type.
	 *
	 * @param value
	 *
	 * @return The boolean value.
	 */
	public static Boolean init( java.lang.Boolean value ) {
		Boolean valueType = (Boolean) init( DataType.BOOLEAN );
		valueType.setValue( value );
		return valueType;
	}

	/**
	 * Initializes a money type.
	 *
	 * @param value
	 *
	 * @return The money value.
	 */
	public static Money init( java.lang.Double value ) {
		Money valueType = (Money) init( DataType.MONEY );
		valueType.setValue( value );
		return valueType;
	}

	/**
	 * Initializes a string type.
	 *
	 * @param value
	 *
	 * @return The string value.
	 */
	public static String init( java.lang.String value ) {
		String valueType = (String) init( DataType.STRING );
		valueType.setValue( value );
		return valueType;
	}

	/**
	 * Initializes an integer type.
	 *
	 * @param value
	 *
	 * @return The integer value.
	 */
	public static Integer init( java.lang.Integer value ) {
		Integer valueType = (Integer) init( DataType.INTEGER );
		valueType.setValue( value );
		return valueType;
	}
}
