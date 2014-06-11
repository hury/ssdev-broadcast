package ctd.net.broadcast;

import java.io.Serializable;

public interface Topic {
	String getId();
	void attach(Observer observer);
	void detach(Observer observer);
	int getObserverCounts();
	void notify(Serializable...args);
}
