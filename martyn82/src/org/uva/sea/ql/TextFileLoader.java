package org.uva.sea.ql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TextFileLoader {
	public static String getFileContents( String fileName ) {
		TextFileLoader instance = new TextFileLoader();
		return instance.getContents( fileName );
	}

	private InputStream openFile( String fileName ) throws IOException {
		return new FileInputStream( fileName );
	}

	private void closeReader( Reader reader ) {
		if ( reader != null ) {
			try {
				reader.close();
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	private String getContents( String fileName ) {
		StringBuffer sb = new StringBuffer();
		InputStreamReader reader = null;

		try {
			reader = new InputStreamReader( this.openFile( fileName ) );

			int c = reader.read();

			while ( c != -1 ) {
				sb.append( (char) c );
				c = reader.read();
			}
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		finally {
			this.closeReader( reader );
		}

		return sb.toString();
	}
}
