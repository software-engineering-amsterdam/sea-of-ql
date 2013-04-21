package nl.stgm.ql;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.form.*;

import java.io.IOException;

public class PrinterRunner implements Visitor
{
	private int indent = 0;
	private boolean indented = true;
	
	public void visit(CalcQuestion cq)
	{
		// cq.calculation().checkType() + 
		print(cq.id() + ": " + cq.question() + " " + " (");
		print(cq.calculation().render());
		println(")");
	}
	
	public void visit(Conditional c)
	{
		print("if(");
		print(c.condition().render());
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
	
	public void visit(BoolQuestion q)
	{
		// + q.type()
		println(q.id() + ": " + q.question() + " ");
	}
	
	public void visit(IntQuestion q)
	{
		// + q.type()
		println(q.id() + ": " + q.question() + " ");
	}
	
	public void visit(ASTExpressionNode e)
	{
		print(e.render());
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
		PrinterRunner ctx = new PrinterRunner();
		Loader loader = new Loader();
		Document document = loader.parseDocument("elaborate.qldoc");
		document.accept(ctx);
	}
}
