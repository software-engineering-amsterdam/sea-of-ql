package nl.stgm.ql.inspectors.pretty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.FileSystems;

import nl.stgm.ql.inspectors.*;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import nl.stgm.ql.parser.*;
import nl.stgm.ql.parser.rats.*;

public class PrettyPrinter extends DocumentInspector implements Visitor
{
	private int indent = 0;
	private boolean indented = true;
	
	public void visit(CalcQuestion cq)
	{
		print(cq.id() + ": " + cq.question() + " " + cq.type() + " (");
		cq.calculation().accept(this);
		println(")");
	}
	
	public void visit(Conditional c)
	{
		print("if(");
		c.condition().accept(this);
		println(") {");
				
		increaseIndent();
		for (Question q: c.ifQuestions())
			q.accept(this);
		decreaseIndent();
		
		println("}");

		if(c.hasElse())
		{
			println("else {");
			increaseIndent();
			for (Question q: c.elseQuestions())
			{
				q.accept(this);
			}
			decreaseIndent();
			println("}");
		}
	}
	
	public void visit(Document d)
	{
		for(Form f: d.forms())
		{
			f.accept(this);
		}
	}
	
	public void visit(Form f)
	{
		println("form " + f.id() + " {");
		increaseIndent();
		for (FormItem formItem: f.formItems())
		{
			formItem.accept(this);
		}
		decreaseIndent();
		println("}");
	}
	
	public void visit(Question q)
	{
		println(q.id() + ": " + q.question() + " " + q.type());
	}
	
	public void visit(Expr e)
	{
		print(e.renderExpression());
	}
	
	//
	// privates
	//

	private void increaseIndent()
	{
		this.indent++;
	}
	
	private void decreaseIndent()
	{
		this.indent--;
	}
	
	private void println(String s)
	{
		printIndent();
		System.out.println(s);
		this.indented = true;
	}
	
	private void println()
	{
		println(null);
	}
	
	private void print(String s)
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
	
	//
	// main
	//
	
	public static void main(String[] args)
	{
		PrettyPrinter ctx = new PrettyPrinter();
		Document document = parseDocument("elaborate.qldoc");
		// document.print(ctx);
		document.accept(ctx);
	}
}
