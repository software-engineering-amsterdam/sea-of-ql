package khosrow.uva.sea.ql.resources;

import java.util.Iterator;
import java.util.Stack;

public class ReverseIterator<T> implements Iterator<T> {
	
	private final Stack<T> stack;

	public ReverseIterator(Iterator<T> iterator) {
		stack = new Stack<T>();
		while (iterator.hasNext())
		stack.push(iterator.next());
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		return stack.pop();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub			
	}


}
