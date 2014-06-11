package ctd.net.broadcast.injvm;

import java.io.Serializable;

import ctd.util.annotation.RpcService;

public interface InjvmSubscriberInterface {
	
	@RpcService
	void notify(String topic, Serializable[] args);

}
