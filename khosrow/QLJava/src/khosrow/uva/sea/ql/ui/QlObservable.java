package khosrow.uva.sea.ql.ui;

import java.util.Observable;

public class QlObservable extends Observable {
		
	public void notifyChange() {
		this.setChanged();
		this.notifyObservers();
	}

}
