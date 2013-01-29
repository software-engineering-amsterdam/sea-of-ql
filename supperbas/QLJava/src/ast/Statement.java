package ast;

public abstract class Statement implements ASTNode {

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
