package nl.stgm.ql.inspectors.pretty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;

import nl.stgm.ql.inspectors.*;

import nl.stgm.ql.ast.form.Document;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

public class PrettyPrinter extends DocumentInspector
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
	
	public static void main(String[] args)
	{
		PrettyPrinter ctx = new PrettyPrinter();
		Document document = parseDocument("elaborate.qldoc");
		document.print(ctx);
	}
}
