package visitor.ui.wrapper;

public class WrapperEvent {
	private final Wrapper wrap;
	
	public WrapperEvent(Wrapper wrap){
		this.wrap = wrap;
	}

	public Wrapper getWrap(){
		return wrap;
	}
	
}
