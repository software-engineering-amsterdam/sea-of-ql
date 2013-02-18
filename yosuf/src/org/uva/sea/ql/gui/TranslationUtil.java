package org.uva.sea.ql.gui;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Expression.Nature;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public class TranslationUtil {

	private TranslationUtil() {
		super();
		// only static methods
	}

	/**
	 * Validates the given value
	 * 
	 * @param nature
	 * @param value
	 * @return
	 */
	public static boolean isValidUserInput(final Nature nature,
			final String value) {
		switch (nature) {
		case TEXTUAL:
			return value != null;

		case NUMERIC:
			try {
				// the following throws a number format exception if the value is not convertable
				Integer.valueOf(value);
			} catch (NumberFormatException e) {
				return false;
			}
		case BOOLEAN:
			return value != null
					&& (value.equalsIgnoreCase("true") || value
							.equalsIgnoreCase("false"));
		default:
			return false;
		}
	}

	public static Expression<?> createExpression(final Nature nature,
			final String value) {
		switch (nature) {
		case NUMERIC:
			return new IntegerValue(Integer.valueOf(value));
		case TEXTUAL:
			return new StringValue(value);
		default:
			throw state
					.createException("Creating other than numeric or textual input should have never been called");
		}
	}
}
