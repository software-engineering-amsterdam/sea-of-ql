package nl.stgm.ql.inspector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;

import nl.stgm.ql.inspector.pretty.*;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

//
// Simple inspector that walks the tree depth-first and prints out class names
//
public class PrettyPrinter implements CodeInspector
{
	public static void main(String[] args)
	{
		RatsParser parser = new RatsParser();
		byte[] file = null;
		String docSource = null;
		
		try
		{
			//
			// hardcoded single sample file
			//
			Path path = FileSystems.getDefault().getPath("samples", "elaborate.qldoc");
			file = Files.readAllBytes(path);
		}
		catch(IOException e)
		{
			System.out.print("Problem loading sample file: ");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		docSource = new String(file);
				
		try
		{
			Document f = parser.parse(docSource);
			f.print(new ConsolePrinter());
		}
		catch(ParseError e)
		{
			System.out.print("Error parsing sample file: ");
			System.out.println(e.getMessage());
		}
	}
}
