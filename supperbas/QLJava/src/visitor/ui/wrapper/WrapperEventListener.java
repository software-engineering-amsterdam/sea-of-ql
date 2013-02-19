package visitor.ui.wrapper;

import java.util.EventListener;

public interface WrapperEventListener extends EventListener {
	abstract void change(WrapperEvent event);
}
