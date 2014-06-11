package ctd.net.broadcast.injvm;

import java.io.Serializable;

import ctd.net.broadcast.Publisher;
import ctd.net.broadcast.exception.BroadException;

public class InjvmPublisher implements Publisher {
	private InjvmSubscriberInterface subscriber;
	private static InjvmPublisher instance;
	
	public InjvmPublisher(){
		instance = this;
	}
	
	public static InjvmPublisher instance(){
		if(instance == null){
			instance = new InjvmPublisher();
			instance.setSubscriber(InjvmSubscriber.instance());
		}
		return instance;
	}
	
	@Override
	public void publish(String topic, Serializable... args) throws BroadException {
		if(subscriber != null){
			subscriber.notify(topic, args);
		}
	}

	public void setSubscriber(InjvmSubscriberInterface subscriber) {
		this.subscriber = subscriber;
	}

}
