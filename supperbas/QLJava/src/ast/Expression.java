package ast;

public abstract class Expression implements ASTNode {

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
