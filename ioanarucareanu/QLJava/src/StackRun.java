class Stack {
    private static class Empty extends Stack { }
    private static class Push extends Stack {
      int value;
      Stack stack;
      public Push(int n, Stack s) {
         value = n;
         stack = s;
      }
    }
    
    static Stack empty() { return new Empty(); }
    static Stack push(int n, Stack s) { return new Push(n, s); }
    static Stack pop(Stack s) throws Exception { 
      if (s instanceof Push) {
        return ((Push)s).stack;
      }
      throw new Exception("illegal");
    }
    static int top(Stack s) throws Exception { 
      if (s instanceof Push) {
        return ((Push)s).value;
      }
      throw new Exception("illegal");
    }
  }

public class StackRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack myStack = Stack.empty();
		myStack = Stack.push(1, myStack);
		myStack = Stack.push(2, myStack);
		System.out.println("ok");
		

	}

}
