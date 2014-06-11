package ctd.net.broadcast.codec.support;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


import ctd.net.broadcast.codec.BroadcastCodec;
import ctd.net.broadcast.exception.BroadException;

public class JSONCodec implements BroadcastCodec {
	 

	@Override
	public byte[] encode(Serializable... args) throws BroadException {
		return JSON.toJSONBytes(args, SerializerFeature.WriteClassName);
	}

	@Override
	public Serializable[] decode(byte[] bytes) throws BroadException {
		return (Serializable[]) JSON.parse(bytes);
	}

}
