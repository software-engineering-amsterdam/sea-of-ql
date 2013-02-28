package org.uva.sea.ql.lead;

/**
 * Static helper class to print objects.
 * 
 */
public class LogPrinter {

	private static boolean debugOn = false;

	private LogPrinter() {
		// only static
	}

	/**
	 * Will print only if {@link #isDebugOn()}
	 * 
	 * @param objects
	 */
	public static void debugInfo(final Object... objects) {
		debug(isDebugOn(), objects);
	}

	/**
	 * 
	 * @param debugOn
	 *            if true, will then print
	 * @param objects
	 */
	public static void debug(final boolean debugOn, final Object... objects) {
		if (debugOn) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
	}

	public static boolean isDebugOn() {
		return debugOn;
	}

	public static void setDebugOn(final boolean debugOn) {
		LogPrinter.debugOn = debugOn;
	}

}
