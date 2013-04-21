package nl.stgm.ql;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import java.io.IOException;

public class PrinterRunner implements Visitor
{
	private int indent = 0;
	private boolean indentNext = true;
	
	public void visit(Document d)
	{
		for(Form f: d.forms())
		{
			f.accept(this);
		}
	}
	
	public void visit(Form f)
	{
		println("form " + f.id());
		println("{");
		increaseIndent();
		for (FormItem formItem: f.formItems())
		{
			formItem.accept(this);
		}
		decreaseIndent();
		println("}");
		println("");
	}
	
	public void visit(Conditional c)
	{
		println("if(" + c.condition().render() + ")");
		println("{");
				
		increaseIndent();
		for (Question q: c.ifQuestions())
			q.accept(this);
		decreaseIndent();
		
		println("}");

		if(c.hasElse())
		{
			println("else");
			println("{");
			increaseIndent();
			for (Question q: c.elseQuestions())
			{
				q.accept(this);
			}
			decreaseIndent();
			println("}");
		}
	}
	
	public void visit(CalcQuestion q)
	{
		println(q.id() + ": " + q.question() + " (" + q.calculation().render() + ")");
	}
	
	public void visit(BoolQuestion q)
	{
		println(q.id() + ": " + q.question() + " boolean");
	}
	
	public void visit(IntQuestion q)
	{
		println(q.id() + ": " + q.question() + " int");
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
		this.indentNext = true;
	}
	
	private void println()
	{
		println(null);
	}
	
	private void print(String s)
	{
		printIndent();
		System.out.print(s);
		this.indentNext = false;
	}

	private void printIndent()
	{
		if(this.indentNext)
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
		PrinterRunner ctx = new PrinterRunner();
		Loader loader = new Loader();
		Document document = loader.parseDocument("elaborate.qldoc");
		document.accept(ctx);
	}
}
