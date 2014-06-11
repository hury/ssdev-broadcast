package ctd.net.broadcast.codec;

import java.io.Serializable;

import ctd.net.broadcast.exception.BroadException;

public interface BroadcastCodec {	
	byte[] encode(Serializable... args) throws BroadException;
	Serializable[] decode(byte[] bytes) throws BroadException;

}
