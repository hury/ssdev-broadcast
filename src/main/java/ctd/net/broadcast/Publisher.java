package ctd.net.broadcast;

import java.io.Serializable;

import ctd.net.broadcast.exception.BroadException;

public interface Publisher {
	void publish(String topic,Serializable...args) throws BroadException;
}
