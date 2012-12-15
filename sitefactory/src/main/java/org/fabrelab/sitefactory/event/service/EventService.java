package org.fabrelab.sitefactory.event.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.fabrelab.sitefactory.event.handler.EventHandler;
import org.fabrelab.sitefactory.event.model.Event;

public class EventService {

	List<EventHandler> handlers = new ArrayList<EventHandler>();
	
	public static BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
	public static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 3000, TimeUnit.MILLISECONDS, taskQueue);
	public void fireEvent(final Event event) {
		executor.execute(new Runnable(){
			public void run(){
				for(EventHandler handler : handlers){
					handler.onEvent(event);
				}
			}
		});
	}
	public List<EventHandler> getHandlers() {
		return handlers;
	}
	public void setHandlers(List<EventHandler> handlers) {
		this.handlers = handlers;
	}

}
