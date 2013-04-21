package nl.stgm.ql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;

import nl.stgm.ql.interfaces.*;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

import nl.stgm.ql.ast.form.Document;

public class Loader
{
	public Document parseDocument(String filename)
	{
		RatsParser parser = new RatsParser();
		byte[] file = null;
		String documentSource;
		
		try
		{
			Path path = FileSystems.getDefault().getPath("samples", filename);
			file = Files.readAllBytes(path);
		}
		catch(IOException e)
		{
			exitWithError("Problem loading sample file: " + e.getMessage());
		}
		catch(OutOfMemoryError e)
		{
			exitWithError("Error: input file too large to fit in memory.");
		}
		catch(SecurityException e)
		{
			exitWithError("Error: no permission to read input file.");
		}

		documentSource = new String(file);
		
		try
		{
			Document document = parser.parse(documentSource);		
			return document;
		}
		catch(ParseError e)
		{
			exitWithError("Error parsing sample file: " + e.getMessage());
			return null; // FML
		}
	}

	private void exitWithError(String message)
	{
		System.out.println(message);
		System.exit(1); // generic "error" exit code
	}
}
