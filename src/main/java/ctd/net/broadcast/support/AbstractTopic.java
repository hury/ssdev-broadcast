package ctd.net.broadcast.support;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

import ctd.net.broadcast.Observer;
import ctd.net.broadcast.Topic;

public class AbstractTopic implements Topic {
	protected final CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList<>();
	protected String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notify(Serializable... args) {
		for(Observer observer : observers){
			try{
				observer.onMessage(args);
			}
			catch(Exception e){
				
			}
		}
		
	}
	
	@Override
	public int getObserverCounts(){
		return observers.size();
	}
}
