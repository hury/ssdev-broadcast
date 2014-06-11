package ctd.net.broadcast;

import ctd.net.broadcast.exception.BroadException;

public interface Subscriber {
	void attach(String topic,Observer observer) throws BroadException;
	void detach(String topic,Observer observer) throws BroadException;
}
