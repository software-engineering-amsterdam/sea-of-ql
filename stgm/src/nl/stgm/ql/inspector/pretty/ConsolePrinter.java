package nl.stgm.ql.inspector.pretty;

public class ConsolePrinter
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
}
