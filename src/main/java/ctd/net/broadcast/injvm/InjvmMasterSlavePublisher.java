package ctd.net.broadcast.injvm;

import java.io.Serializable;

import ctd.net.broadcast.Publisher;
import ctd.net.broadcast.exception.BroadException;

public class InjvmMasterSlavePublisher implements Publisher {
	private InjvmSubscriberInterface subscriber;
	private InjvmSubscriber masterSubscriber;

	@Override
	public void publish(String topic, Serializable... args) throws BroadException {
		if(subscriber != null){
			subscriber.notify(topic, args);
		}
		if(masterSubscriber != null){
			masterSubscriber.notify(topic,args);
		}
	}

	public void setSlaveSubscriber(InjvmSubscriberInterface subscriber) {
		this.subscriber = subscriber;
	}

	public void setMasterSubscriber(InjvmSubscriber masterSubscriber) {
		this.masterSubscriber = masterSubscriber;
	}

}
