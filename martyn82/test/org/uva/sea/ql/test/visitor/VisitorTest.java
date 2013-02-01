package org.uva.sea.ql.test.visitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.jacc.QLParser;

/**
 * Implements basic functionality of visitor test classes.
 * @param <T>
 */
abstract public class VisitorTest<T> {
	/**
	 * Holds the parser object.
	 */
	protected final IParser parser;

	/**
	 * Holds the read program from file.
	 */
	protected final String program;

	/**
	 * Constructs a new VisitorTest instance.
	 */
	protected VisitorTest() {
		this.parser = new QLParser();
		this.program = this.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );
	}

	/**
	 * Retrieves contents of given file.
	 *
	 * @param fileName
	 *
	 * @return The contents.
	 */
	private String getFileContents( String fileName ) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String line;

		try {
			br = new BufferedReader( new FileReader( fileName ) );

			while ( ( line = br.readLine() ) != null ) {
				sb.append( line );
			}
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		finally {
			if ( br != null ) {
				try {
					br.close();
				}
				catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}
}
