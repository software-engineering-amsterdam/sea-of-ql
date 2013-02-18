package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileLoader {
	public static String getFileContents( String fileName ) {
		FileLoader instance = new FileLoader();
		return instance.getContents( fileName );
	}

	private Reader openFile( String fileName ) throws IOException {
		return new FileReader( fileName );
	}

	private void closeFile( Reader file ) {
		if ( file != null ) {

			try {
				file.close();
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	private String getContents( String fileName ) {
		StringBuffer sb = new StringBuffer();
		String line;
		BufferedReader reader = null;

		try {
			reader = new BufferedReader( this.openFile( fileName ) );

			while ( ( line = reader.readLine() ) != null ) {
				sb.append( line );
			}
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		finally {
			this.closeFile( reader );
		}

		return sb.toString();
	}
}
