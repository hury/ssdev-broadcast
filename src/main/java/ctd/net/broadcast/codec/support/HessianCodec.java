package ctd.net.broadcast.codec.support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianFactory;
import com.caucho.hessian.io.SerializerFactory;

import ctd.net.broadcast.codec.BroadcastCodec;
import ctd.net.broadcast.exception.BroadException;

public class HessianCodec implements BroadcastCodec {
	 private static final HessianFactory hf = new HessianFactory();
	 static{
		 hf.setSerializerFactory(new SerializerFactory());
	 }

	@Override
	public byte[] encode(Serializable... args) throws BroadException {
		ByteArrayOutputStream outs = new ByteArrayOutputStream();
		Hessian2Output h2out = hf.createHessian2Output(outs);
		try {
			h2out.writeObject(args);
			h2out.close();
		} 
		catch (IOException e) {
			throw new BroadException(e,BroadException.CODEC_FAILED);
		}
		return outs.toByteArray();
	}

	@Override
	public Serializable[] decode(byte[] bytes) throws BroadException {
		ByteArrayInputStream ins = new ByteArrayInputStream(bytes);
		Hessian2Input h2input = hf.createHessian2Input(ins);
		try {
			return (Serializable[]) h2input.readObject();
			
		}
		catch (IOException e) {
			throw new BroadException(e,BroadException.CODEC_FAILED);
		}
		
	}

}
