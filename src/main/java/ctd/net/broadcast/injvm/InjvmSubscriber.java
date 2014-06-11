package ctd.net.broadcast.injvm;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ctd.net.broadcast.Observer;
import ctd.net.broadcast.Subscriber;
import ctd.net.broadcast.exception.BroadException;

public class InjvmSubscriber implements Subscriber,InjvmSubscriberInterface {
	private static InjvmSubscriber instance;
	private Map<String,InjvmTopic> topics = new ConcurrentHashMap<>();
	
	public InjvmSubscriber(){
		instance = this;
	}
	
	public static InjvmSubscriber instance(){
		if(instance == null){
			instance = new InjvmSubscriber();
		}
		return instance;
	}
	
	@Override
	public void attach(String topic, Observer observer) throws BroadException {
		InjvmTopic t = null;
		if(!topics.containsKey(t)){
			t = new InjvmTopic(topic);
			topics.put(topic, t);
		}
		else{
			t = topics.get(topic);
		}
		t.attach(observer);
	}

	@Override
	public void detach(String topic, Observer observer) throws BroadException {
		if(topics.containsKey(topic)){
			InjvmTopic t = topics.get(topic);
			t.detach(observer);
		}
	}
	
	@Override
	public void notify(String topic,Serializable[] args){
		if(topics.containsKey(topic)){
			InjvmTopic t = topics.get(topic);
			t.notify(args);
		}
	}
}
