package ctd.net.broadcast.codec;

import ctd.net.broadcast.codec.support.HessianCodec;
import ctd.net.broadcast.codec.support.JSONCodec;

public class BroadcastCodecFactory {
	public static final String HESSIAN = "hessian";
	public static final String JSON = "json";
	
	private static final BroadcastCodec HESSIAN_CODEC = new HessianCodec();
	private static final BroadcastCodec JSON_CODEC = new JSONCodec();
	
	
	public static BroadcastCodec getCodec(String codec){
		switch(codec){
			case HESSIAN:
				return HESSIAN_CODEC;
			case JSON:
				return JSON_CODEC;
			default:
				return HESSIAN_CODEC;
		}
	}

}
