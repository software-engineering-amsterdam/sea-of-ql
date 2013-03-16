package nl.stgm.ql.inspectors.pretty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;

import nl.stgm.ql.ast.form.Document;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

//
// Simple inspector that walks the tree depth-first and prints out class names
//
public class PrettyPrinter
{
	private int indent = 0;
	private boolean indented = true;
	
	public void increaseIndent()
	{
		this.indent++;
	}
	
	public void decreaseIndent()
	{
		this.indent--;
	}
	
	private void printIndent()
	{
		if(this.indented)
		{
			for(int i = 0; i < indent; i++)
			{
				System.out.print("\t");
			}
		}
	}
	
	public void println(String s)
	{
		printIndent();
		System.out.println(s);
		this.indented = true;
	}
	
	public void println()
	{
		println(null);
	}
	
	public void print(String s)
	{
		printIndent();
		System.out.print(s);
		this.indented = false;
	}

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
			f.print(new PrettyPrinter());
		}
		catch(ParseError e)
		{
			System.out.print("Error parsing sample file: ");
			System.out.println(e.getMessage());
		}
	}
}
